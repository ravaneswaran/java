package rave.code.quartz.job.stockbase;

import rave.code.quartz.enums.ASCIIColorCodes;
import rave.code.quartz.enums.DailyPriceListDownloadLink;
import rave.code.quartz.enums.NSEStockClassification;
import rave.code.stockmarket.entity.NSEStockBase10Entity;
import rave.code.stockmarket.entity.StockBase10Entity;
import rave.code.stockmarket.repository.StockBase10Repository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.zip.ZipFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class NSEStockBase10EntityMakerJob extends AbstractEntityMakerJob<List<String>, List<StockBase10Entity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEStockBase10EntityMakerJob.class.getName());

    private StockBase10Repository stockBaseRepository = new StockBase10Repository();
    private Date date;

    public NSEStockBase10EntityMakerJob() {
        this(new Date());
    }

    public NSEStockBase10EntityMakerJob(Date date) {
        this.date = date;
    }

    @Override
    public List<String> getDataFromSource() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
        String formattedDate = simpleDateFormat.format(this.date);
        String url = String.format(DailyPriceListDownloadLink.DAY_PRICE_LIST_DOWNLOAD_LINK_NSE.get(), formattedDate);
        LOGGER.log(Level.INFO, String.format("Downloading file... %s", url));
        FileDownloader fileDownloader = new FileDownloader();
        String zipEntryFileName = String.format("Pd%s.csv", formattedDate);

        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = fileDownloader.downloadFile(url);
             InputStream csvFileInputStream = new ZipFileReader().read(inputStream, zipEntryFileName);) {
            lines = new SimpleFileReader().read(csvFileInputStream);
        } catch (FileNotFoundException ioException) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", url));
            LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
            LOGGER.log(Level.SEVERE, String.format("the day the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY)", sdf.format(this.date)));
            LOGGER.log(Level.SEVERE, String.format("the system expects the file now but will be made available only after 6:00 PM..", sdf.format(this.date)));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }
        return lines;
    }

    @Override
    public List<StockBase10Entity> transformSourceData(List<String> sourceData) {
        List<StockBase10Entity> nseStockBaseEntities = new ArrayList<>();
        int lineNumber = 1;

        for (String line : sourceData) {
            String[] lineDetails = line.split(",");

            if (1 == lineNumber) {
                LOGGER.log(Level.INFO, "skipping the header... ");
                LOGGER.log(Level.INFO, "<<<<< paring indexes... >>>>>");
                lineNumber = lineNumber + 1;
                continue;
            }
            if ("".equals(lineDetails[2].trim()) && "".equals(lineDetails[3].trim()) && "".equals(lineDetails[4].trim())) {
                continue;
            }
            if ("".equals(lineDetails[2].trim()) && !"".equals(lineDetails[3].trim()) && "".equals(lineDetails[4].trim())) {
                LOGGER.log(Level.INFO, String.format("<<<<< paring the section... %s >>>>>", lineDetails[3]));
                continue;
            }

            String mkt = lineDetails[0].trim();
            String series = lineDetails[1].trim();
            NSEStockClassification nseStockClassification = NSEStockClassification.getClassification(series);
            if(mkt.equalsIgnoreCase("Y") && NSEStockClassification.DEFAULT.equals(nseStockClassification)){
                series = NSEStockClassification.getClassification("Index").getSeriesCode();
            }

            StockBase10Entity stockBaseEntity = new NSEStockBase10Entity();
            stockBaseEntity.setMkt(mkt);
            stockBaseEntity.setSeries(series);
            stockBaseEntity.setStockSymbol(lineDetails[2].trim());
            stockBaseEntity.setStockName(lineDetails[3].trim());
            stockBaseEntity.setPreviousClosePrice(lineDetails[4].trim());
            stockBaseEntity.setOpenPrice(lineDetails[5].trim());
            stockBaseEntity.setHighPrice(lineDetails[6].trim());
            stockBaseEntity.setLowPrice(lineDetails[7].trim());
            String closePrice = lineDetails[8].trim();
            stockBaseEntity.setClosePrice(closePrice);
            stockBaseEntity.setNetTradedValue(lineDetails[9].trim());
            stockBaseEntity.setNetTradedQuantity(lineDetails[10].trim());
            stockBaseEntity.setIndexOrSecurity(lineDetails[11].trim());
            stockBaseEntity.setCorpIndex(lineDetails[12].trim());
            stockBaseEntity.setTrades(lineDetails[13].trim());
            stockBaseEntity.setHigh52Week(lineDetails[14].trim());
            stockBaseEntity.setLow52Week(lineDetails[15].trim());
            stockBaseEntity.setDailyClosePrice(closePrice);
            Date now = new Date();
            stockBaseEntity.setCreatedDate(now);
            stockBaseEntity.setModifiedDate(now);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            nseStockBaseEntities.add(stockBaseEntity);
        }

        return nseStockBaseEntities;
    }

    @Override
    public void saveTransformedData(List<StockBase10Entity> transformedData) {
        String source = "NSE";
        Map<String, StockBase10Entity> mappedStockBaseEntities = this.stockBaseRepository.findBySource(source);

        if (mappedStockBaseEntities.size() == 0) {
            LOGGER.log(Level.INFO, String.format("%sLoading fresh set of NSE stocks into the repository...", ASCIIColorCodes.WHITE.get()));
            this.stockBaseRepository.bulkUpsert(transformedData);
        } else {
            List<StockBase10Entity> stockBaseEntities = new ArrayList<>();
            for (StockBase10Entity stockBaseEntity : transformedData) {
                if (mappedStockBaseEntities.size() > 0) {
                    String key = String.format("%s:%s:%s:%s:%s", source, stockBaseEntity.getMkt(), stockBaseEntity.getSeries(), stockBaseEntity.getStockSymbol(), stockBaseEntity.getStockName());
                    StockBase10Entity mappedStockBaseEntity = mappedStockBaseEntities.get(key);
                    if (null != mappedStockBaseEntity) {
                        LOGGER.log(Level.INFO, String.format("[%s] - Stock is already available in the repository hence updating it...", key));
                        stockBaseEntity.setNewEntity(false);
                        String dailyClosePrice = String.format("%s:%s", mappedStockBaseEntity.getDailyClosePrice(), stockBaseEntity.getDailyClosePrice());
                        mappedStockBaseEntity.setDailyClosePrice(dailyClosePrice);
                        stockBaseEntities.add(mappedStockBaseEntity);
                    } else {
                        LOGGER.log(Level.INFO, String.format("%s[%s]%s - Stock is not available in the repository hence creating it...", ASCIIColorCodes.WHITE.get(), key, ASCIIColorCodes.GREEN.get()));
                        stockBaseEntities.add(stockBaseEntity);
                    }
                }
            }
            this.stockBaseRepository.bulkUpsert(stockBaseEntities);
        }
    }
}
