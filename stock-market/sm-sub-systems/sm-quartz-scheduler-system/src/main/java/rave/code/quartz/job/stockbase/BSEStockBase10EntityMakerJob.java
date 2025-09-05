package rave.code.quartz.job.stockbase;

import org.apache.commons.csv.CSVRecord;
import rave.code.quartz.enums.ASCIIColorCodes;
import rave.code.quartz.enums.DailyPriceListDownloadLink;
import rave.code.quartz.jobs.AbstractEntityMakerJob;
import rave.code.stockmarket.entity.BSEStockBase10Entity;
import rave.code.stockmarket.entity.StockBase10Entity;
import rave.code.stockmarket.repository.StockBase10Repository;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;
import rave.code.utility.download.FileDownloader;

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

class BSEStockBase10EntityMakerJob extends AbstractEntityMakerJob<List<CSVRecord>, List<StockBase10Entity>> {

    private static final Logger LOGGER = Logger.getLogger(BSEStockBase10EntityMakerJob.class.getName());

    private StockBase10Repository stockBaseRepository = new StockBase10Repository();
    private Date date;

    public BSEStockBase10EntityMakerJob() {
        this(new Date());
    }

    public BSEStockBase10EntityMakerJob(Date date) {
        this.date = date;
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String url = String.format(DailyPriceListDownloadLink.DAY_PRICE_LIST_DOWNLOAD_LINK_BSE.get(), simpleDateFormat.format(this.date));
        LOGGER.log(Level.INFO, String.format("Downloading file... %s", url));
        FileDownloader fileDownloader = new FileDownloader();
        List<CSVRecord> csvRecords = new ArrayList<>();
        try (InputStream inputStream = fileDownloader.downloadFile(url)) {
            ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
            csvRecords = apacheCommonsCSVReader.read(inputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", url));
            LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
            LOGGER.log(Level.SEVERE, String.format("the day which the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY) or...", sdf.format(this.date)));
            LOGGER.log(Level.SEVERE, String.format("the system expects the file now but will be made available only after 6:00 PM..", sdf.format(this.date)));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }
        return csvRecords;
    }

    @Override
    public List<StockBase10Entity> transformSourceData(List<CSVRecord> sourceData) {
        List<StockBase10Entity> bseStockBaseEntities = new ArrayList<>();
        int lineNumber = 1;

        for (CSVRecord csvRecord : sourceData) {
            if (1 == lineNumber) {
                LOGGER.log(Level.INFO, "skipping the header... ");
                LOGGER.log(Level.INFO, "<<<<< paring indexes... >>>>>");
                lineNumber = lineNumber + 1;
                continue;
            }

            BSEStockBase10Entity bseStockBaseEntity = new BSEStockBase10Entity();

            bseStockBaseEntity.setMkt(csvRecord.get(2));
            bseStockBaseEntity.setFinancialInstrumentType(csvRecord.get(4));
            bseStockBaseEntity.setFinancialInstrumentId(csvRecord.get(5));
            bseStockBaseEntity.setISIN(csvRecord.get(6));
            bseStockBaseEntity.setStockSymbol(csvRecord.get(7));
            bseStockBaseEntity.setSeries(csvRecord.get(8));
            bseStockBaseEntity.setStockName(csvRecord.get(13));
            bseStockBaseEntity.setOpenPrice(csvRecord.get(14));
            bseStockBaseEntity.setHighPrice(csvRecord.get(15));
            bseStockBaseEntity.setLowPrice(csvRecord.get(16));
            bseStockBaseEntity.setClosePrice(csvRecord.get(17));
            bseStockBaseEntity.setPreviousClosePrice(csvRecord.get(19));
            bseStockBaseEntity.setNetTradedQuantity(csvRecord.get(24));
            bseStockBaseEntity.setNetTradedValue(csvRecord.get(25));
            bseStockBaseEntity.setIndexOrSecurity("N/A");
            bseStockBaseEntity.setCorpIndex("N/A");
            bseStockBaseEntity.setTrades("N/A");
            bseStockBaseEntity.setHigh52Week("N/A");
            bseStockBaseEntity.setLow52Week("N/A");
            bseStockBaseEntity.setDailyClosePrice(csvRecord.get(17));
            Date now = new Date();
            bseStockBaseEntity.setCreatedDate(now);
            bseStockBaseEntity.setModifiedDate(now);
            bseStockBaseEntity.setCreatedBy("SYSTEM");
            bseStockBaseEntity.setModifiedBy("SYSTEM");

            bseStockBaseEntities.add(bseStockBaseEntity);
        }
        return bseStockBaseEntities;
    }

    @Override
    public void saveTransformedData(List<StockBase10Entity> transformedData) {
        String source = "BSE";
        Map<String, StockBase10Entity> mappedStockBaseEntities = this.stockBaseRepository.findBySource(source);

        if (mappedStockBaseEntities.size() == 0) {
            LOGGER.log(Level.INFO, String.format("%sLoading fresh set of BSE stocks into the repository...", ASCIIColorCodes.WHITE.get()));
            this.stockBaseRepository.bulkUpsert(transformedData);
        } else {
            List<StockBase10Entity> stockBaseEntities = new ArrayList<>();
            for (StockBase10Entity stockBaseEntity : transformedData) {
                if (mappedStockBaseEntities.size() > 0) {
                    String key = String.format("%s:%s:%s:%s:%s", source, stockBaseEntity.getISIN(), stockBaseEntity.getSeries(), stockBaseEntity.getStockSymbol(), stockBaseEntity.getStockName());
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
