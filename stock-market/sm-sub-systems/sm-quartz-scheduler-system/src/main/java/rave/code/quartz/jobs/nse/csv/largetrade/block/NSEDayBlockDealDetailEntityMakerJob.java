package rave.code.quartz.jobs.nse.csv.largetrade.block;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEDayBlockDealDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.largetrade.AbstractNSECSVLargeTradeEntityMakerJob;
import rave.code.repository.nse.NSEDayBlockDealDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.File;
import java.io.IOException;
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

public class NSEDayBlockDealDetailEntityMakerJob extends AbstractNSECSVLargeTradeEntityMakerJob<List<NSEDayBlockDealDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEDayBlockDealDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEDayBlockDealDetailRepository nseDayBlockDealDetailRepository = new NSEDayBlockDealDetailRepository();

    public NSEDayBlockDealDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/historicalOR/bulk-block-short-deals?csv=true&optionType=block_deals&from=%s&to=%s");
        this.setDownloadPageUrl("https://www.nseindia.com/report-detail/display-bulk-and-block-deals");
        LocalDate now = LocalDate.now();
        LocalDate historicalDate = now.minusDays(1);
        Date fromDate = Date.from(historicalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.reconstructCsvDownloadUrl(fromDate);
    }

    @Override
    public List<NSEDayBlockDealDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEDayBlockDealDetailEntity> nseDayBlockDealDetailEntities = new ArrayList<>();
        if (sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String nowAsStr = simpleDateFormat.format(now);
        for (CSVRecord csvRecord : sourceData) {
            String businessDate = csvRecord.get(0).trim();
            if(nowAsStr.equals(businessDate)){
                NSEDayBlockDealDetailEntity nseDayBlockDealDetailEntity = new NSEDayBlockDealDetailEntity();
                String symbol = csvRecord.get(1);
                try {
                    nseDayBlockDealDetailEntity.setBusinessDate(simpleDateFormat.parse(businessDate));
                } catch (ParseException exception) {
                    LOGGER.log(Level.SEVERE, String.format("BusinessDate of %s has raised ParseException(%s)", symbol, exception.getMessage()));
                }

                nseDayBlockDealDetailEntity.setSymbol(symbol);
                nseDayBlockDealDetailEntity.setSecurityName(csvRecord.get(2));
                nseDayBlockDealDetailEntity.setClientName(csvRecord.get(3));
                nseDayBlockDealDetailEntity.setDealType(csvRecord.get(4));

                try {
                    nseDayBlockDealDetailEntity.setQuantityTraded(Integer.parseInt(csvRecord.get(5).replaceAll(",", "")));
                } catch (NumberFormatException numberFormatException) {
                    LOGGER.log(Level.SEVERE, String.format("QuantityTraded of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
                }
                try {
                    nseDayBlockDealDetailEntity.setTradePrice(Double.parseDouble(csvRecord.get(6).replaceAll(",", "")));
                } catch (NumberFormatException numberFormatException) {
                    LOGGER.log(Level.SEVERE, String.format("TradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
                }
                nseDayBlockDealDetailEntity.setRemarks(csvRecord.get(7));
                nseDayBlockDealDetailEntities.add(nseDayBlockDealDetailEntity);
            }
        }
        return nseDayBlockDealDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEDayBlockDealDetailEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSEDayBlockDealDetailEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEDayBlockDealDetailEntity> nseDayBlockDealDetailEntities = new ArrayList<>();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSEDayBlockDealDetailEntity nseDayBlockDealDetailEntity : transformedData) {
            String key = nseDayBlockDealDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseDayBlockDealDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseDayBlockDealDetailEntities.add(nseDayBlockDealDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("stock base entity for(%s) does not exists...hence creating it.", key, nseDayBlockDealDetailEntity.getSymbol()));
                NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nseDayBlockDealDetailEntity.getSymbol(), null, null, null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
            }
        }
        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nseDayBlockDealDetailRepository.bulkUpsert(nseDayBlockDealDetailEntities);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEDayBlockDealDetailEntityMakerJob nseBlockDealEntityMakerJob = new NSEDayBlockDealDetailEntityMakerJob();
        nseBlockDealEntityMakerJob.saveTransformedData(nseBlockDealEntityMakerJob.transformSourceData(nseBlockDealEntityMakerJob.getDataFromSource()));
    }
}
