package rave.code.quartz.jobs.nse.csv.live.spurts;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.live.AbstractNSELiveMarketEntityMakerJob;
import rave.code.repository.nse.NSEPriceSpurtDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractNSEPriceSpurtDetailEntityMakerJob extends AbstractNSELiveMarketEntityMakerJob<List<NSEPriceSpurtDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(AbstractNSEPriceSpurtDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPriceSpurtDetailRepository nsePriceSpurtsDetailRepository = new NSEPriceSpurtDetailRepository();

    protected String spurtType;

    public AbstractNSEPriceSpurtDetailEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
        this.spurtType = "STOCK-PRICE>20";
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEPriceSpurtDetailEntity> nsePriceSpurtsDetailEntities = new ArrayList<>();
        if(sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        for (CSVRecord csvRecord : sourceData) {
            NSEPriceSpurtDetailEntity nsePriceSpurtsDetailEntity = new NSEPriceSpurtDetailEntity();

            nsePriceSpurtsDetailEntity.setSpurtType(this.spurtType);
            String symbol = csvRecord.get(0).trim();
            nsePriceSpurtsDetailEntity.setSymbol(symbol);
            try {
                nsePriceSpurtsDetailEntity.setOpenPrice(Double.parseDouble(csvRecord.get(1).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("OpenPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setHighPrice(Double.parseDouble(csvRecord.get(2).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("HighPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setLowPrice(Double.parseDouble(csvRecord.get(3).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LowPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setPreviousClosePrice(Double.parseDouble(csvRecord.get(4).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClosePrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setLastTradedPrice(Double.parseDouble(csvRecord.get(5).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LastTradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setPercentageChange(Double.parseDouble(csvRecord.get(6).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setVolume(Integer.parseInt(csvRecord.get(7).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("Volume of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setValue(Double.parseDouble(csvRecord.get(8).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("Value of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nsePriceSpurtsDetailEntity.setCA(simpleDateFormat.parse(csvRecord.get(9).trim().replaceAll(",", "")));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, String.format("CA of %s has raised ParseException(%s)", symbol, parseException.getMessage()));
            }
            nsePriceSpurtsDetailEntities.add(nsePriceSpurtsDetailEntity);
        }

        return nsePriceSpurtsDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEPriceSpurtDetailEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSEPriceSpurtDetailEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEPriceSpurtDetailEntity> nsePriceSpurtsDetailEntities = new ArrayList<>();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSEPriceSpurtDetailEntity nsePriceSpurtsDetailEntity : transformedData) {
            String key = nsePriceSpurtsDetailEntity.getKey();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nsePriceSpurtsDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity for(%s) does not exists...hence creating it.", key, nsePriceSpurtsDetailEntity.getSymbol()));
                NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nsePriceSpurtsDetailEntity.getSymbol(), null, null, null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
            }
            nsePriceSpurtsDetailEntities.add(nsePriceSpurtsDetailEntity);
        }
        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nsePriceSpurtsDetailRepository.bulkUpsert(nsePriceSpurtsDetailEntities);
    }
}
