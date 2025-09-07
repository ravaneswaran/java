package rave.code.quartz.jobs.nse.csv.live.spurts;

import org.apache.commons.csv.CSVRecord;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.csv.NSEVolumeSpurtDetailEntity;
import rave.code.quartz.jobs.nse.csv.live.AbstractNSELiveMarketEntityMakerJob;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.repository.nse.NSEVolumeSpurtDetailRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEVolumeSpurtsDetailEntityMakerJob extends AbstractNSELiveMarketEntityMakerJob<List<NSEVolumeSpurtDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceSpurtSPLwr20DetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEVolumeSpurtDetailRepository nseVolumeSpurtsDetailRepository = new NSEVolumeSpurtDetailRepository();

    public NSEVolumeSpurtsDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-volume-gainers?csv=true");
    }

    @Override
    public List<NSEVolumeSpurtDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEVolumeSpurtDetailEntity> nseVolumeSpurtsDetailEntities = new ArrayList<>();
        int lineNumber = 1;

        for (CSVRecord csvRecord : sourceData) {
            if (1 == lineNumber) {
                LOGGER.log(Level.INFO, "Skipping the header... ");
                lineNumber = lineNumber + 1;
                continue;
            }

            NSEVolumeSpurtDetailEntity nseVolumeSpurtsDetailEntity = new NSEVolumeSpurtDetailEntity();
            String symbol = csvRecord.get(0).trim();
            nseVolumeSpurtsDetailEntity.setSymbol(symbol);
            try {
                nseVolumeSpurtsDetailEntity.setVolume(Integer.parseInt(csvRecord.get(1).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("Volume of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseVolumeSpurtsDetailEntity.setOneWeekAverageVolume(Integer.parseInt(csvRecord.get(2).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("OneWeekAverageVolume of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseVolumeSpurtsDetailEntity.setNoOfTimes(Double.parseDouble(csvRecord.get(3).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("NoOfTimes of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }

            nseVolumeSpurtsDetailEntities.add(nseVolumeSpurtsDetailEntity);
        }

        return nseVolumeSpurtsDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEVolumeSpurtDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEVolumeSpurtDetailEntity> nseVolumeSpurtsDetailEntities = new ArrayList<>();

        for (NSEVolumeSpurtDetailEntity nseVolumeSpurtsDetailEntity : transformedData) {
            String key = nseVolumeSpurtsDetailEntity.getKey();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseVolumeSpurtsDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseVolumeSpurtsDetailEntities.add(nseVolumeSpurtsDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity not for(%s) exists...", key, nseVolumeSpurtsDetailEntity.getSymbol()));
            }
        }
        this.nseVolumeSpurtsDetailRepository.bulkUpsert(nseVolumeSpurtsDetailEntities);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSEVolumeSpurtsDetailEntityMakerJob nseVolumeSpurtsDetailEntityMakerJob = new NSEVolumeSpurtsDetailEntityMakerJob();
        nseVolumeSpurtsDetailEntityMakerJob.saveTransformedData(nseVolumeSpurtsDetailEntityMakerJob.transformSourceData(nseVolumeSpurtsDetailEntityMakerJob.getDataFromSource()));
    }
}