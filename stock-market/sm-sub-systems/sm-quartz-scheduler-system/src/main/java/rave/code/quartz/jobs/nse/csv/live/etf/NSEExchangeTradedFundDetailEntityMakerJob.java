package rave.code.quartz.jobs.nse.csv.live.etf;

import org.apache.commons.csv.CSVRecord;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSEExchangeTradedFundDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.live.AbstractNSELiveMarketEntityMakerJob;
import rave.code.repository.nse.NSEExchangeTradedFundDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEExchangeTradedFundDetailEntityMakerJob extends AbstractNSELiveMarketEntityMakerJob<List<NSEExchangeTradedFundDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEExchangeTradedFundDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEExchangeTradedFundDetailRepository nseExchangeTradedFundDetailRepository = new NSEExchangeTradedFundDetailRepository();

    public NSEExchangeTradedFundDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-most-active-etf-csv?index=value&csv=true");
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        return this.getDataFromSource(true);
    }

    @Override
    public List<NSEExchangeTradedFundDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEExchangeTradedFundDetailEntity> nseExchangeTradedFundDetailEntities = new ArrayList<>();
        if(sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }

        for (CSVRecord csvRecord : sourceData) {
            NSEExchangeTradedFundDetailEntity nseExchangeTradedFundDetailEntity = new NSEExchangeTradedFundDetailEntity();

            String symbol = csvRecord.get(0).trim();
            nseExchangeTradedFundDetailEntity.setSymbol(symbol);
            try {
                nseExchangeTradedFundDetailEntity.setOpenPrice(Double.parseDouble(csvRecord.get(1).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("OpenPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseExchangeTradedFundDetailEntity.setHighPrice(Double.parseDouble(csvRecord.get(2).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("HighPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseExchangeTradedFundDetailEntity.setLowPrice(Double.parseDouble(csvRecord.get(3).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LowPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseExchangeTradedFundDetailEntity.setLastTradedPrice(Double.parseDouble(csvRecord.get(4).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LastTradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseExchangeTradedFundDetailEntity.setNetAssetValue(Double.parseDouble(csvRecord.get(5).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClosePrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseExchangeTradedFundDetailEntity.setPercentageChange(Double.parseDouble(csvRecord.get(6).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseExchangeTradedFundDetailEntity.setVolumeInShares(Integer.parseInt(csvRecord.get(7).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("VolumeInShares of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseExchangeTradedFundDetailEntity.setValueInLakhs(Double.parseDouble(csvRecord.get(8).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("ValueInLakhs of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }

            nseExchangeTradedFundDetailEntities.add(nseExchangeTradedFundDetailEntity);
        }

        return nseExchangeTradedFundDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEExchangeTradedFundDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEExchangeTradedFundDetailEntity> nseExchangeTradedFundDetailEntities = new ArrayList<>();

        for (NSEExchangeTradedFundDetailEntity nseExchangeTradedFundDetailEntity : transformedData) {
            String key = nseExchangeTradedFundDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseExchangeTradedFundDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseExchangeTradedFundDetailEntities.add(nseExchangeTradedFundDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity for(%s) does not exists...hence creating it.", key, nseExchangeTradedFundDetailEntity.getSymbol()));
            }
        }
        this.nseExchangeTradedFundDetailRepository.bulkUpsert(nseExchangeTradedFundDetailEntities);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();
        NSEExchangeTradedFundDetailEntityMakerJob nseExchangeTradedFundDetailEntityMakerJob = new NSEExchangeTradedFundDetailEntityMakerJob();
        nseExchangeTradedFundDetailEntityMakerJob.saveTransformedData(nseExchangeTradedFundDetailEntityMakerJob.transformSourceData(nseExchangeTradedFundDetailEntityMakerJob.getDataFromSource()));
    }
}
