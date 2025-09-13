package rave.code.quartz.jobs.nse.csv.shorts;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEDayShortSellDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;
import rave.code.repository.nse.NSEDayShortSellDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.text.ParseException;
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

public class NSEDayShortSellDetailEntityMakerJob extends AbstractNSECSVEntityMakerJob<List<NSEDayShortSellDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEDayShortSellDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEDayShortSellDetailRepository nseDayShortSellDetailRepository = new NSEDayShortSellDetailRepository();

    public NSEDayShortSellDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/historicalOR/bulk-block-short-deals?csv=true&optionType=short_selling&from=%s&to=%s");
        this.setDownloadPageUrl("https://www.nseindia.com/report-detail/display-bulk-and-block-deals");
        this.initialize();
    }

    private void initialize(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate toLocalDate = LocalDate.parse(simpleDateFormat.format(new Date()), formatter);
        Date toDate = Date.from(toLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String toDateStr = simpleDateFormat.format(toDate);
        this.setCsvDownloadUrl(String.format(this.csvDownloadUrl, toDateStr, toDateStr));
    }

    @Override
    public List<NSEDayShortSellDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEDayShortSellDetailEntity> nseDayShortSellDetailEntities = new ArrayList<>();
        if (sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }
        for (CSVRecord csvRecord : sourceData) {
            NSEDayShortSellDetailEntity nseDayShortSellDetailEntity = new NSEDayShortSellDetailEntity();
            String symbol = csvRecord.get(1);
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                nseDayShortSellDetailEntity.setBusinessDate(simpleDateFormat.parse(csvRecord.get(0)));
            } catch (ParseException exception) {
                LOGGER.log(Level.SEVERE, String.format("BusinessDate of %s has raised NumberFormatException(%s)", symbol, exception.getMessage()), exception);
            }
            nseDayShortSellDetailEntity.setSymbol(symbol);
            nseDayShortSellDetailEntity.setSecurityName(csvRecord.get(2));
            try {
                nseDayShortSellDetailEntity.setQuantity(Integer.parseInt(csvRecord.get(3).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("Quantity of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            nseDayShortSellDetailEntities.add(nseDayShortSellDetailEntity);
        }
        return nseDayShortSellDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEDayShortSellDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEDayShortSellDetailEntity> nseDayShortSellDetailEntities = new ArrayList<>();

        for (NSEDayShortSellDetailEntity nseDayShortSellDetailEntity : transformedData) {
            String key = nseDayShortSellDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseDayShortSellDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseDayShortSellDetailEntities.add(nseDayShortSellDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("stock base entity for(%s) does not exists...hence creating it.", key, nseDayShortSellDetailEntity.getSymbol()));
            }
        }
        this.nseDayShortSellDetailRepository.bulkUpsert(nseDayShortSellDetailEntities);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEDayShortSellDetailEntityMakerJob nseDayShortSellDetailEntityMakerJob = new NSEDayShortSellDetailEntityMakerJob();
        nseDayShortSellDetailEntityMakerJob.saveTransformedData(nseDayShortSellDetailEntityMakerJob.transformSourceData(nseDayShortSellDetailEntityMakerJob.getDataFromSource()));
    }
}
