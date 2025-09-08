package rave.code.quartz.jobs.nse.csv.preopen;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractNSEPreOpenMarketEntityMakerJob extends AbstractNSECSVEntityMakerJob<List<NSEPreOpenMarketDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(AbstractNSEPreOpenMarketEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    protected String preOpenType;

    public AbstractNSEPreOpenMarketEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
        super.setDownloadPageUrl("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        return this.getDataFromSource(true);
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEPreOpenMarketDetailEntity> nsePreOpenMarketDetailEntities = new ArrayList<>();
        CSVRecord header = sourceData.remove(0);
        LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        for (CSVRecord csvRecord : sourceData) {
            NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity = new NSEPreOpenMarketDetailEntity();
            nsePreOpenMarketDetailEntity.setPreOpenType(this.preOpenType);
            String symbol = csvRecord.get(0);
            nsePreOpenMarketDetailEntity.setSymbol(symbol);
            try {
                nsePreOpenMarketDetailEntity.setPreviousClose(Double.parseDouble(csvRecord.get(1).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClose of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setPreviousClose(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setIndicativeEquilibriumPrice(Double.parseDouble(csvRecord.get(2).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("IndicativeEquilibriumPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setIndicativeEquilibriumPrice(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setPriceChange(Double.parseDouble(csvRecord.get(3).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("change of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setPriceChange(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setPricePercentageChange(Double.parseDouble(csvRecord.get(4).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setPricePercentageChange(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setFinalPrice(Double.parseDouble(csvRecord.get(5).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("FinalPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalPrice(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setFinalQuantity(Integer.parseInt(csvRecord.get(6).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("FinalQuantity of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalQuantity(0);
            }
            try {
                nsePreOpenMarketDetailEntity.setValueInCrores(new BigDecimal(csvRecord.get(7).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("ValueInCrores of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalQuantity(0);
            }
            try {
                nsePreOpenMarketDetailEntity.setFreeFloatMarketCapitalization(new BigDecimal(csvRecord.get(8).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("FreeFloatMarketCapitalization of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalQuantity(0);
            }
            try {
                nsePreOpenMarketDetailEntity.setNewMarket52WeekHigh(Double.parseDouble(csvRecord.get(9).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("NewMarket52WeekHigh of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setNewMarket52WeekHigh(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setNewMarket52WeekLow(Double.parseDouble(csvRecord.get(10).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("NewMarket52WeekLow of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setNewMarket52WeekLow(0.00);
            }
            nsePreOpenMarketDetailEntities.add(nsePreOpenMarketDetailEntity);
        }
        return nsePreOpenMarketDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEPreOpenMarketDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEPreOpenMarketDetailEntity> properNsePreOpenMarketDetailEntities = new ArrayList<>();

        for (NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity : transformedData) {
            String key = nsePreOpenMarketDetailEntity.getKey();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nsePreOpenMarketDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                properNsePreOpenMarketDetailEntities.add(nsePreOpenMarketDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity not for(%s) exists...", key, nsePreOpenMarketDetailEntity.getSymbol()));
            }
        }
        this.nsePreOpenMarketDetailRepository.bulkUpsert(properNsePreOpenMarketDetailEntities);
    }

}
