package rave.code.quartz.jobs.nse.csv.stockbase;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.utility.log.JavaUtilLogDecor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSESMEEquityStockBaseEntityMakerJob extends AbstractNSEStockBaseCSVEntityMakerJob {

    private static final Logger LOGGER = Logger.getLogger(NSESMEEquityStockBaseEntityMakerJob.class.getName());

    public NSESMEEquityStockBaseEntityMakerJob() {
        super("https://nsearchives.nseindia.com/emerge/corporates/content/SME_EQUITY_L.csv");
    }

    @Override
    public List<NSEStockBaseEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();
        if(sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }

        for (CSVRecord csvRecord : sourceData) {
            NSEStockBaseEntity nseStockBaseEntity = new NSEStockBaseEntity();

            nseStockBaseEntity.setSymbol(csvRecord.get(0));
            nseStockBaseEntity.setCompanyName(csvRecord.get(1));
            nseStockBaseEntity.setSeries(csvRecord.get(2));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            try {
                Date dateOfListing = simpleDateFormat.parse(csvRecord.get(3));
                nseStockBaseEntity.setDateOfListing(dateOfListing);
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage());
            }
            try {
                int paidUpValue = Integer.parseInt(csvRecord.get(4));
                nseStockBaseEntity.setPaidUpValue(paidUpValue);
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
            }
            nseStockBaseEntity.setMarketLot(0);
            nseStockBaseEntity.setISINumber(csvRecord.get(5));
            try {
                int faceValue = Integer.parseInt(csvRecord.get(6));
                nseStockBaseEntity.setMarketLot(faceValue);
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
            }

            nseStockBaseEntities.add(nseStockBaseEntity);
        }
        return nseStockBaseEntities;
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSESMEEquityStockBaseEntityMakerJob nseSMEEquityStockBaseEntityMakerJob = new NSESMEEquityStockBaseEntityMakerJob();
        nseSMEEquityStockBaseEntityMakerJob.saveTransformedData(nseSMEEquityStockBaseEntityMakerJob.transformSourceData(nseSMEEquityStockBaseEntityMakerJob.getDataFromSource()));
    }
}
