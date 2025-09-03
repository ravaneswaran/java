package rave.code.quartz.job.stockbase.nse;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.job.stockbase.AbstractCSVEntityMakerJob;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.log.JavaUtilLogDecor;

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

public class NSEPreOpenMarketEntityMakeJob extends AbstractCSVEntityMakerJob<List<CSVRecord>, List<NSEPreOpenMarketDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEPreOpenMarketEntityMakeJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketEntityMakeJob() {
        this("https://www.nseindia.com/api/market-data-pre-open?key=NIFTY&csv=true");
    }

    public NSEPreOpenMarketEntityMakeJob(String downloadUrl) {
        super(downloadUrl);
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        FileDownloader fileDownloader = new FileDownloader();
        List<CSVRecord> csvRecords = new ArrayList<>();
        try (InputStream inputStream = fileDownloader.downloadFile(this.downloadUrl)) {
            ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
            csvRecords = apacheCommonsCSVReader.read(inputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", this.downloadUrl));
            LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
            LOGGER.log(Level.SEVERE, String.format("the day which the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY) or...", sdf.format(new Date())));
            LOGGER.log(Level.SEVERE, String.format("the system expects the file now but will be made available only after 6:00 PM..", sdf.format(new Date())));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }
        return csvRecords;
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEPreOpenMarketDetailEntity> nsePreOpenMarketDetailEntities = new ArrayList<>();
        int lineNumber = 1;

        for (CSVRecord csvRecord : sourceData) {
            if (1 == lineNumber) {
                LOGGER.log(Level.INFO, "Skipping the header... ");
                lineNumber = lineNumber + 1;
                continue;
            }

            NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity = new NSEPreOpenMarketDetailEntity();
            nsePreOpenMarketDetailEntity.setSymbol(csvRecord.get(0));
            try {
                nsePreOpenMarketDetailEntity.setPreviousClose(Double.parseDouble(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setPreviousClose(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setIndicativeEquilibriumPrice(Double.parseDouble(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setIndicativeEquilibriumPrice(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setChange(Double.parseDouble(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setChange(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setPercentageChange(Double.parseDouble(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setPercentageChange(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setFinalPrice(Double.parseDouble(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalPrice(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setFinalQuantity(Integer.parseInt(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalQuantity(0);
            }
            nsePreOpenMarketDetailEntity.setValueInCrores(csvRecord.get(0));
            nsePreOpenMarketDetailEntity.setFreeFloatMarketCapitalization(csvRecord.get(0));
            try {
                nsePreOpenMarketDetailEntity.setNewMarket52WeekHigh(Double.parseDouble(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setNewMarket52WeekHigh(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setNewMarket52WeekLow(Double.parseDouble(csvRecord.get(0)));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage(), numberFormatException);
                nsePreOpenMarketDetailEntity.setNewMarket52WeekLow(0.00);
            }

            nsePreOpenMarketDetailEntities.add(nsePreOpenMarketDetailEntity);
        }
        return nsePreOpenMarketDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEPreOpenMarketDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.getEntityMapForPreOpenMarketDetails();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity : transformedData) {
            String key = nsePreOpenMarketDetailEntity.getKey();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nsePreOpenMarketDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity not exists...", key));
                /*NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nseDayPriceDetailEntity.getSymbol(), nseDayPriceDetailEntity.getCompanyName(), nseDayPriceDetailEntity.getSeries(), null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
                nseDayPriceDetailEntity.setNseStockBaseEntity(nseStockBaseEntityToCreate);*/
            }
        }

        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nsePreOpenMarketDetailRepository.bulkUpsert(transformedData);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketEntityMakeJob nsePreOpenMarketEntityMakeJob = new NSEPreOpenMarketEntityMakeJob();
        nsePreOpenMarketEntityMakeJob.saveTransformedData(nsePreOpenMarketEntityMakeJob.transformSourceData(nsePreOpenMarketEntityMakeJob.getDataFromSource()));
    }
}
