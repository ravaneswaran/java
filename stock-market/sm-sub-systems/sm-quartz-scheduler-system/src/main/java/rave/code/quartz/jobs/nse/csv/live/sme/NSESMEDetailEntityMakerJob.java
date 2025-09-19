package rave.code.quartz.jobs.nse.csv.live.sme;

import org.apache.commons.csv.CSVRecord;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSESMEDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.live.AbstractNSELiveMarketEntityMakerJob;
import rave.code.repository.nse.NSESMEDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSESMEDetailEntityMakerJob extends AbstractNSELiveMarketEntityMakerJob<List<NSESMEDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSESMEDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSESMEDetailRepository nseSmeDetailRepository = new NSESMEDetailRepository();

    public NSESMEDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-most-active-sme-csv?index=volume&csv=true");
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        return this.getDataFromSource(true);
    }


    @Override
    public List<NSESMEDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSESMEDetailEntity> nseSmeDetailEntities = new ArrayList<>();
        if(sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }

        for (CSVRecord csvRecord : sourceData) {

            NSESMEDetailEntity nseSmeDetailEntity = new NSESMEDetailEntity();
            String symbol = csvRecord.get(0).trim();
            nseSmeDetailEntity.setSymbol(symbol);
            try {
                nseSmeDetailEntity.setOpenPrice(Double.parseDouble(csvRecord.get(1).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("OpenPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setHighPrice(Double.parseDouble(csvRecord.get(2).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("HighPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setLowPrice(Double.parseDouble(csvRecord.get(3).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LowPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setPreviousClosePrice(Double.parseDouble(csvRecord.get(4).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClosePrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setLastTradedPrice(Double.parseDouble(csvRecord.get(5).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LastTradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setPercentageChange(Double.parseDouble(csvRecord.get(6).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setVolume(Integer.parseInt(csvRecord.get(7).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("Volume of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setValueInLakhs(Double.parseDouble(csvRecord.get(8).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("ValueInLakhs of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }

            nseSmeDetailEntities.add(nseSmeDetailEntity);
        }

        return nseSmeDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSESMEDetailEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSESMEDetailEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSESMEDetailEntity> nseSmeDetailEntities = new ArrayList<>();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSESMEDetailEntity nseSmeDetailEntity : transformedData) {
            String key = nseSmeDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseSmeDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseSmeDetailEntities.add(nseSmeDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity for(%s) does not exists...hence creating it.", key, nseSmeDetailEntity.getSymbol()));
                NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nseSmeDetailEntity.getSymbol(), null, null, null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
            }
        }
        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nseSmeDetailRepository.bulkUpsert(nseSmeDetailEntities);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSESMEDetailEntityMakerJob nseSmeDetailEntityMakerJob = new NSESMEDetailEntityMakerJob();
        nseSmeDetailEntityMakerJob.saveTransformedData(nseSmeDetailEntityMakerJob.transformSourceData(nseSmeDetailEntityMakerJob.getDataFromSource()));
    }
}
