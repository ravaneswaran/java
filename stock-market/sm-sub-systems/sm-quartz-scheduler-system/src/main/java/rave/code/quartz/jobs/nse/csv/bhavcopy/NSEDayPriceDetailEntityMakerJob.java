package rave.code.quartz.jobs.nse.csv.bhavcopy;

import rave.code.entity.nse.NSEDayPriceLastRunDetailEntity;
import rave.code.entity.nse.csv.NSEDayPriceDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.process.SubProcess;
import rave.code.quartz.enums.DailyPriceListDownloadLink;
import rave.code.quartz.enums.NSEStockClassification;
import rave.code.quartz.jobs.AbstractCSVEntityMakerJob;
import rave.code.repository.nse.NSEDayPriceDetailRepository;
import rave.code.repository.nse.NSEDayPriceLastRunDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.log.JavaUtilLogDecor;
import rave.code.utility.zip.ZipFileReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEDayPriceDetailEntityMakerJob extends AbstractCSVEntityMakerJob<List<String>, List<NSEDayPriceDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEDayPriceDetailEntityMakerJob.class.getName());

    private Date date;
    private final NSEDayPriceDetailRepository nseDayPriceDetailRepository = new NSEDayPriceDetailRepository();
    private final NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private final NSEDayPriceLastRunDetailRepository nseDayPriceLastRunDetailRepository = new NSEDayPriceLastRunDetailRepository();

    List<Date> dates = new ArrayList<>();

    public NSEDayPriceDetailEntityMakerJob() {
        this(new Date());
    }

    public NSEDayPriceDetailEntityMakerJob(Date date) {
        super("");
        this.initialize(date);
    }

    private void initialize(Date date) {
        this.date = date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
        String formattedDate = simpleDateFormat.format(this.date);
        this.setCsvDownloadUrl(String.format(DailyPriceListDownloadLink.DAY_PRICE_LIST_DOWNLOAD_LINK_NSE.get(), formattedDate));
    }

    private List<String> getCsvFileLines(InputStream zipFileInputStream, String zipEntryFileName) {
        List<String> lines = new ArrayList<>();
        if (null != zipFileInputStream) {
            InputStream zipFileEntryCsvInputStream = null;
            try {
                zipFileEntryCsvInputStream = new ZipFileReader().read(zipFileInputStream, zipEntryFileName);
            } catch (IOException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
            }
            if (null != zipFileEntryCsvInputStream) {
                try {
                    lines = new SimpleFileReader().read(zipFileEntryCsvInputStream);
                } catch (IOException exception) {
                    LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
                }
                try {
                    zipFileEntryCsvInputStream.close();
                } catch (IOException exception) {
                    LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
                }
            }
        }
        return lines;
    }

    @Override
    public List<String> getDataFromSource() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
        String formattedDate = simpleDateFormat.format(this.date);
        String url = String.format(DailyPriceListDownloadLink.DAY_PRICE_LIST_DOWNLOAD_LINK_NSE.get(), formattedDate);
        LOGGER.log(Level.INFO, String.format("Downloading file... %s", url));
        FileDownloader fileDownloader = new FileDownloader();
        List<String> lines = new ArrayList<>();
        try {
            InputStream zipFileInputStream = fileDownloader.downloadFile(url);
            if (null != zipFileInputStream) {
                byte[] fileContent = zipFileInputStream.readAllBytes(); // this line is very important
                InputStream zipFileInputStreamCopyOne = new ByteArrayInputStream(fileContent);
                InputStream zipFileInputStreamCopyTwo = new ByteArrayInputStream(fileContent);
                simpleDateFormat = new SimpleDateFormat("ddMMyy");
                formattedDate = simpleDateFormat.format(this.date);
                String zipEntryFileName = String.format("Pd%s.csv", formattedDate);
                lines = this.getCsvFileLines(zipFileInputStreamCopyOne, zipEntryFileName);
                zipFileInputStreamCopyOne.close();
                if (lines.isEmpty()) {
                    simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
                    formattedDate = simpleDateFormat.format(this.date);
                    zipEntryFileName = String.format("Pd%s.csv", formattedDate);
                    lines = this.getCsvFileLines(zipFileInputStreamCopyTwo, zipEntryFileName);
                    zipFileInputStreamCopyTwo.close();
                }
                zipFileInputStream.close();
            }
        } catch (IOException exception) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", url));
            LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
            LOGGER.log(Level.SEVERE, String.format("1. the day the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY)", sdf.format(this.date)));
            LOGGER.log(Level.SEVERE, String.format("2. the system expects the file now but will be made available only after market closes(approximately after 04:15 PM)..", sdf.format(this.date)));
        }
        return lines;
    }

    @Override
    public List<NSEDayPriceDetailEntity> transformSourceData(List<String> sourceData) {
        List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(simpleDateFormat.format(this.date), formatter);
        Date businessDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (!sourceData.isEmpty()) {
            String header = sourceData.removeFirst();
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }
        int lineNumber = 1;

        for (String line : sourceData) {
            String[] lineDetails = line.split(",");

            if (1 == lineNumber) {
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
            if (mkt.equalsIgnoreCase("Y") && NSEStockClassification.DEFAULT.equals(nseStockClassification)) {
                series = NSEStockClassification.getClassification("Index").getSeriesCode();
            }

            NSEDayPriceDetailEntity nseDayPriceDetailEntity = new NSEDayPriceDetailEntity();
            nseDayPriceDetailEntity.setBusinessDate(businessDate);
            nseDayPriceDetailEntity.setMkt(mkt);
            nseDayPriceDetailEntity.setSeries(series);
            String symbol = lineDetails[2].trim();
            symbol = "".equals(symbol) ? "-" : symbol;
            nseDayPriceDetailEntity.setSymbol(symbol);
            nseDayPriceDetailEntity.setCompanyName(lineDetails[3].trim());
            nseDayPriceDetailEntity.setPreviousClosePrice(lineDetails[4].trim());
            nseDayPriceDetailEntity.setOpenPrice(lineDetails[5].trim());
            nseDayPriceDetailEntity.setHighPrice(lineDetails[6].trim());
            nseDayPriceDetailEntity.setLowPrice(lineDetails[7].trim());
            String closePrice = lineDetails[8].trim();
            nseDayPriceDetailEntity.setClosePrice(closePrice);
            nseDayPriceDetailEntity.setNetTradedValue(lineDetails[9].trim());
            nseDayPriceDetailEntity.setNetTradedQuantity(lineDetails[10].trim());
            nseDayPriceDetailEntity.setIndexOrSecurity(lineDetails[11].trim());
            nseDayPriceDetailEntity.setCorpIndex(lineDetails[12].trim());
            nseDayPriceDetailEntity.setTrades(lineDetails[13].trim());
            nseDayPriceDetailEntity.setHigh52Week(lineDetails[14].trim());
            nseDayPriceDetailEntity.setLow52Week(lineDetails[15].trim());
            Date now = new Date();
            nseDayPriceDetailEntity.setCreatedDate(now);
            nseDayPriceDetailEntity.setModifiedDate(now);
            nseDayPriceDetailEntity.setCreatedBy("SYSTEM");
            nseDayPriceDetailEntity.setModifiedBy("SYSTEM");

            nseDayPriceDetailEntities.add(nseDayPriceDetailEntity);
        }

        return nseDayPriceDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEDayPriceDetailEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSEDayPriceDetailEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.getEntityMapForDayPriceDetails();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSEDayPriceDetailEntity nseDayPriceDetailEntity : transformedData) {
            String key = nseDayPriceDetailEntity.getKey();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseDayPriceDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity does not exists...hence creating it.", key));
                NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nseDayPriceDetailEntity.getSymbol(), nseDayPriceDetailEntity.getCompanyName(), nseDayPriceDetailEntity.getSeries(), null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
                nseDayPriceDetailEntity.setNseStockBaseEntity(nseStockBaseEntityToCreate);
            }
        }

        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nseDayPriceDetailRepository.bulkUpsert(transformedData);
        LOGGER.log(Level.INFO, String.format("Number of NSEDayPriceDetailEntity.... %s", transformedData.size()));

        this.updateLastRun();
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    @Override
    public SubProcess action() throws IOException {
        for (Date date : this.dates) {
            this.initialize(date);
            this.saveTransformedData(this.transformSourceData(this.getDataFromSource()));
        }
        //this.updateLastRun();
        return this;
    }

    private void updateLastRun(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date now = new Date();
        NSEDayPriceLastRunDetailEntity nseDayPriceLastRunDetailEntity = this.nseDayPriceLastRunDetailRepository.find();
        if (null == nseDayPriceLastRunDetailEntity) {
            nseDayPriceLastRunDetailEntity = new NSEDayPriceLastRunDetailEntity();
        }
        nseDayPriceLastRunDetailEntity.setLastRunAtStr(simpleDateFormat.format(now));
        nseDayPriceLastRunDetailEntity.setLastRunAt(now);
        nseDayPriceLastRunDetailEntity.setModifiedDate(now);

        this.nseDayPriceLastRunDetailRepository.upsert(nseDayPriceLastRunDetailEntity);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
    }
}
