package rave.code.quartz.jobs.nse.csv.ratios;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEPriceToEarningRatioDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;
import rave.code.repository.nse.NSEPriceToEarningRatioDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPriceToEarningRatioEntityMakerJob extends AbstractNSECSVEntityMakerJob<List<NSEPriceToEarningRatioDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceToEarningRatioEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPriceToEarningRatioDetailRepository nsePriceToEarningRatioDetailRepository = new NSEPriceToEarningRatioDetailRepository();

    public NSEPriceToEarningRatioEntityMakerJob() {
        super("");
        this.setDownloadPageUrl("");
    }

    @Override
    public List<NSEPriceToEarningRatioDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEPriceToEarningRatioDetailEntity> nsePriceToEarningRatioDetailEntities = new ArrayList<>();
        if (sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }
        for (CSVRecord csvRecord : sourceData) {
            NSEPriceToEarningRatioDetailEntity nsePriceToEarningRatioDetailEntity = new NSEPriceToEarningRatioDetailEntity();

            String symbol = csvRecord.get(0);
            nsePriceToEarningRatioDetailEntity.setSymbol(symbol);
            nsePriceToEarningRatioDetailEntity.setSymbolPE(Double.parseDouble(csvRecord.get(1)));
            nsePriceToEarningRatioDetailEntity.setAdjustedPE(Double.parseDouble(csvRecord.get(2)));

            nsePriceToEarningRatioDetailEntities.add(nsePriceToEarningRatioDetailEntity);
        }
        return nsePriceToEarningRatioDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEPriceToEarningRatioDetailEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSEPriceToEarningRatioDetailEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();

        List<NSEPriceToEarningRatioDetailEntity> nsePriceToEarningRatioDetailEntities = new ArrayList<>();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSEPriceToEarningRatioDetailEntity nsePriceToEarningRatioDetailEntity : transformedData) {
            String key = nsePriceToEarningRatioDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nsePriceToEarningRatioDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nsePriceToEarningRatioDetailEntities.add(nsePriceToEarningRatioDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("stock base entity for(%s) does not exists...hence creating it.", key, nsePriceToEarningRatioDetailEntity.getSymbol()));
                NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nsePriceToEarningRatioDetailEntity.getSymbol(), null, null, null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
            }
        }

        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nsePriceToEarningRatioDetailRepository.bulkUpsert(nsePriceToEarningRatioDetailEntities);
    }
}
