package rave.code.quartz.jobs.nse.csv.largetrade.bulk;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEDayBulkDealDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.largetrade.AbstractNSECSVLargeTradeEntityMakerJob;
import rave.code.repository.nse.NSEDayBulkDealDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEDayBulkDealDetailEntityMakerJob extends AbstractNSECSVLargeTradeEntityMakerJob<List<NSEDayBulkDealDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEDayBulkDealDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEDayBulkDealDetailRepository nseDayBulkDealDetailRepository = new NSEDayBulkDealDetailRepository();

    public NSEDayBulkDealDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/historicalOR/bulk-block-short-deals?csv=true&optionType=bulk_deals&from=%s&to=%s");
        this.setDownloadPageUrl("https://www.nseindia.com/report-detail/display-bulk-and-block-deals");
        this.reconstructCsvDownloadUrl();
    }

    @Override
    public List<NSEDayBulkDealDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEDayBulkDealDetailEntity> nseDayBulkDealDetailEntities = new ArrayList<>();
        if (sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        } else {
            LOGGER.log(Level.WARNING, String.format("Malformed csv file..."));
        }
        for (CSVRecord csvRecord : sourceData) {
            NSEDayBulkDealDetailEntity nseDayBulkDealDetailEntity = new NSEDayBulkDealDetailEntity();
            String symbol = csvRecord.get(1);

            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                nseDayBulkDealDetailEntity.setBusinessDate(simpleDateFormat.parse(csvRecord.get(0)));
            } catch (ParseException exception) {
                LOGGER.log(Level.SEVERE, String.format("BusinessDate of %s has raised NumberFormatException(%s)", symbol, exception.getMessage()), exception);
            }

            nseDayBulkDealDetailEntity.setSymbol(symbol);
            nseDayBulkDealDetailEntity.setSecurityName(csvRecord.get(2));
            nseDayBulkDealDetailEntity.setClientName(csvRecord.get(3));
            nseDayBulkDealDetailEntity.setDealType(csvRecord.get(4));
            try {
                nseDayBulkDealDetailEntity.setQuantityTraded(Integer.parseInt(csvRecord.get(5).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("QuantityTraded of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseDayBulkDealDetailEntity.setTradePrice(Double.parseDouble(csvRecord.get(6).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("TradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            nseDayBulkDealDetailEntity.setRemarks(csvRecord.get(7));
            nseDayBulkDealDetailEntities.add(nseDayBulkDealDetailEntity);
        }
        return nseDayBulkDealDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEDayBulkDealDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEDayBulkDealDetailEntity> nseDayBulkDealDetailEntities = new ArrayList<>();

        for (NSEDayBulkDealDetailEntity nseDayBulkDealDetailEntity : transformedData) {
            String key = nseDayBulkDealDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseDayBulkDealDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseDayBulkDealDetailEntities.add(nseDayBulkDealDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("stock base entity for(%s) does not exists...hence creating it.", key, nseDayBulkDealDetailEntity.getSymbol()));
            }
        }
        this.nseDayBulkDealDetailRepository.bulkUpsert(nseDayBulkDealDetailEntities);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEDayBulkDealDetailEntityMakerJob nseDayBulkDealEntityMakerJob = new NSEDayBulkDealDetailEntityMakerJob();
        nseDayBulkDealEntityMakerJob.saveTransformedData(nseDayBulkDealEntityMakerJob.transformSourceData(nseDayBulkDealEntityMakerJob.getDataFromSource()));
    }
}
