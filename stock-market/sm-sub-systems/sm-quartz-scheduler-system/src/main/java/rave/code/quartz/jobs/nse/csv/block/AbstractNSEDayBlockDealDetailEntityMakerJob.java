package rave.code.quartz.jobs.nse.csv.block;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEDayBlockDealDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;
import rave.code.repository.nse.NSEDayBlockDealDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;

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

public abstract class AbstractNSEDayBlockDealDetailEntityMakerJob extends AbstractNSECSVEntityMakerJob<List<NSEDayBlockDealDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(AbstractNSEDayBlockDealDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEDayBlockDealDetailRepository nseDayBlockDealDetailRepository = new NSEDayBlockDealDetailRepository();

    public AbstractNSEDayBlockDealDetailEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
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
    public List<NSEDayBlockDealDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEDayBlockDealDetailEntity> nseDayBlockDealDetailEntities = new ArrayList<>();
        if (sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }
        for (CSVRecord csvRecord : sourceData) {
            NSEDayBlockDealDetailEntity nseDayBlockDealDetailEntity = new NSEDayBlockDealDetailEntity();
            String symbol = csvRecord.get(1);

            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                nseDayBlockDealDetailEntity.setBusinessDate(simpleDateFormat.parse(csvRecord.get(0)));
            } catch (ParseException exception) {
                LOGGER.log(Level.SEVERE, String.format("BusinessDate of %s has raised NumberFormatException(%s)", symbol, exception.getMessage()), exception);
            }

            nseDayBlockDealDetailEntity.setSymbol(symbol);
            nseDayBlockDealDetailEntity.setSecurityName(csvRecord.get(2));
            nseDayBlockDealDetailEntity.setClientName(csvRecord.get(3));
            nseDayBlockDealDetailEntity.setDealType(csvRecord.get(4));
            try {
                nseDayBlockDealDetailEntity.setQuantityTraded(Integer.parseInt(csvRecord.get(5).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("QuantityTraded of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseDayBlockDealDetailEntity.setTradePrice(Double.parseDouble(csvRecord.get(6).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("TradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            nseDayBlockDealDetailEntity.setRemarks(csvRecord.get(7));
            nseDayBlockDealDetailEntities.add(nseDayBlockDealDetailEntity);
        }
        return nseDayBlockDealDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEDayBlockDealDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEDayBlockDealDetailEntity> nseDayBlockDealDetailEntities = new ArrayList<>();

        for (NSEDayBlockDealDetailEntity nseDayBlockDealDetailEntity : transformedData) {
            String key = nseDayBlockDealDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseDayBlockDealDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseDayBlockDealDetailEntities.add(nseDayBlockDealDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("stock base entity for(%s) does not exists...hence creating it.", key, nseDayBlockDealDetailEntity.getSymbol()));
            }
        }
        this.nseDayBlockDealDetailRepository.bulkUpsert(nseDayBlockDealDetailEntities);
    }
}
