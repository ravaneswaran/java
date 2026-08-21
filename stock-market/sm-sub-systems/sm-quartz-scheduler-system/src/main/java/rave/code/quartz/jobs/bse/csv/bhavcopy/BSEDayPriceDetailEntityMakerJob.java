package rave.code.quartz.jobs.bse.csv.bhavcopy;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.bse.csv.BSEDayPriceDetailEntity;
import rave.code.entity.bse.csv.BSEStockBaseEntity;
import rave.code.java.date.StockMarketDate;
import rave.code.quartz.enums.DailyPriceListDownloadLink;
import rave.code.quartz.jobs.AbstractEntityMakerJob;
import rave.code.repository.bse.BSEDayPriceDetailRepository;
import rave.code.repository.bse.BSEStockBaseRepository;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEDayPriceDetailEntityMakerJob extends AbstractEntityMakerJob<List<CSVRecord>, List<BSEDayPriceDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(BSEDayPriceDetailEntityMakerJob.class.getName());

    private BSEStockBaseRepository bseStockBaseRepository = new BSEStockBaseRepository();
    private BSEDayPriceDetailRepository bseDayPriceDetailRepository = new BSEDayPriceDetailRepository();

    private Date date;

    public BSEDayPriceDetailEntityMakerJob() {
        this(StockMarketDate.getInstance().now());
    }

    public BSEDayPriceDetailEntityMakerJob(Date date) {
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
    public List<BSEDayPriceDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<BSEDayPriceDetailEntity> bseDayPriceDetailEntities = new ArrayList<>();
        int lineNumber = 1;

        for (CSVRecord csvRecord : sourceData) {
            if (1 == lineNumber) {
                LOGGER.log(Level.INFO, "skipping the header... ");
                lineNumber = lineNumber + 1;
                continue;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            BSEDayPriceDetailEntity bseDayPriceDetailEntity = new BSEDayPriceDetailEntity();

            try {
                bseDayPriceDetailEntity.setTradedDate(simpleDateFormat.parse(csvRecord.get(0).trim()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseDayPriceDetailEntity.setTradedDate(null);
            }
            try {
                bseDayPriceDetailEntity.setBusinessDate(simpleDateFormat.parse(csvRecord.get(1).trim()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseDayPriceDetailEntity.setBusinessDate(null);
            }
            bseDayPriceDetailEntity.setSegment(csvRecord.get(2).trim());
            bseDayPriceDetailEntity.setFinancialInstrumentType(csvRecord.get(4).trim());
            bseDayPriceDetailEntity.setFinancialInstrumentId(csvRecord.get(5).trim());
            bseDayPriceDetailEntity.setISINumber(csvRecord.get(6).trim());
            bseDayPriceDetailEntity.setTickerSymbol(csvRecord.get(7).trim());
            bseDayPriceDetailEntity.setSecuritySeries(csvRecord.get(8).trim());
            try {
                bseDayPriceDetailEntity.setExpiryDate(simpleDateFormat.parse(csvRecord.get(9).trim()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseDayPriceDetailEntity.setExpiryDate(null);
            }
            try {
                bseDayPriceDetailEntity.setFinancialInstrumentActualExpiryDate(simpleDateFormat.parse(csvRecord.get(10).trim()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseDayPriceDetailEntity.setFinancialInstrumentActualExpiryDate(null);
            }
            try {
                bseDayPriceDetailEntity.setStrikePrice(Double.parseDouble(csvRecord.get(11).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setStrikePrice(0.0);
            }
            bseDayPriceDetailEntity.setOptionType(csvRecord.get(12).trim());
            bseDayPriceDetailEntity.setFinancialInstrumentName(csvRecord.get(13).trim());
            try {
                bseDayPriceDetailEntity.setOpenPrice(Double.parseDouble(csvRecord.get(14).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setOpenPrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setHighPrice(Double.parseDouble(csvRecord.get(15).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setHighPrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setLowPrice(Double.parseDouble(csvRecord.get(16).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setLowPrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setClosePrice(Double.parseDouble(csvRecord.get(17).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setClosePrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setLastPrice(Double.parseDouble(csvRecord.get(18).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setLastPrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setPreviousClosePrice(Double.parseDouble(csvRecord.get(19).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setPreviousClosePrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setUnderlyingPrice(Double.parseDouble(csvRecord.get(20).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setUnderlyingPrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setSettlementPrice(Double.parseDouble(csvRecord.get(21).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setSettlementPrice(0.0);
            }
            try {
                bseDayPriceDetailEntity.setOpenInterest(Double.parseDouble(csvRecord.get(22).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setOpenInterest(0.0);
            }
            bseDayPriceDetailEntity.setChangeInOpenInterest(csvRecord.get(23).trim());
            try {
                bseDayPriceDetailEntity.setTotalTradedVolume(Integer.parseInt(csvRecord.get(24).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setTotalTradedVolume(0.0);
            }
            try {
                bseDayPriceDetailEntity.setTotalTradedValue(Double.parseDouble(csvRecord.get(25).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setTotalTradedValue(0.0);
            }
            try {
                bseDayPriceDetailEntity.setTotalNumberOfTransactionsExecuted(Integer.parseInt(csvRecord.get(26).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                bseDayPriceDetailEntity.setTotalNumberOfTransactionsExecuted(0);
            }
            bseDayPriceDetailEntity.setSessionId(csvRecord.get(27).trim());
            bseDayPriceDetailEntity.setNewBoardLotQuantity(csvRecord.get(28).trim());

            bseDayPriceDetailEntities.add(bseDayPriceDetailEntity);
        }
        return bseDayPriceDetailEntities;
    }

    @Override
    public void saveTransformedData(List<BSEDayPriceDetailEntity> transformedData) {
        Map<String, BSEStockBaseEntity> mappedStockBaseEntities = this.bseStockBaseRepository.getEntityMap();
        List<BSEStockBaseEntity> bseStockBaseEntities = new ArrayList<>();

        for (BSEDayPriceDetailEntity bseDayPriceDetailEntity : transformedData) {
            String key = bseDayPriceDetailEntity.getISINumber();
            BSEStockBaseEntity bseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != bseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                bseDayPriceDetailEntity.setBseStockBaseEntity(bseStockBaseEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity not exists...", key));
                BSEStockBaseEntity bseStockBaseEntityToCreate = BSEStockBaseEntity.newInstance(bseDayPriceDetailEntity.getFinancialInstrumentId(), bseDayPriceDetailEntity.getFinancialInstrumentName(), bseDayPriceDetailEntity.getSecuritySeries(), bseDayPriceDetailEntity.getISINumber());
                bseStockBaseEntities.add(bseStockBaseEntityToCreate);
                bseDayPriceDetailEntity.setBseStockBaseEntity(bseStockBaseEntityToCreate);
            }
        }

        this.bseStockBaseRepository.bulkUpsert(bseStockBaseEntities);
        this.bseDayPriceDetailRepository.bulkUpsert(transformedData);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
        LocalDate today = LocalDate.now();
        List<Date> dates = new ArrayList<>();
        for (int index = 10; index >= 1; index--) {
            LocalDate pastLocalDate = today.minusDays(index);
            Date pastDate = Date.from(pastLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            dates.add(pastDate);
        }
        for (Date date : dates) {
            BSEDayPriceDetailEntityMakerJob bseDayPriceDetailEntityMakerJob = new BSEDayPriceDetailEntityMakerJob(date);
            bseDayPriceDetailEntityMakerJob.saveTransformedData(bseDayPriceDetailEntityMakerJob.transformSourceData(bseDayPriceDetailEntityMakerJob.getDataFromSource()));
        }
    }
}
