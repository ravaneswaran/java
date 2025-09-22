package rave.code.quartz.jobs.nse.csv.live.top20;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.quartz.jobs.nse.csv.live.AbstractNSELiveMarketEntityMakerJob;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractNSETop20DetailEntityMakerJob extends AbstractNSELiveMarketEntityMakerJob<List<NSETop20DetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(AbstractNSETop20DetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();
    protected String top20Type;
    protected String top20SubType;

    public AbstractNSETop20DetailEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
        super.setDownloadPageUrl("https://www.nseindia.com/market-data/top-gainers-losers");;
    }

    public void setTop20Type(String top20Type) {
        this.top20Type = top20Type;
    }

    public void setTop20SubType(String top20SubType) {
        this.top20SubType = top20SubType;
    }

    @Override
    public List<NSETop20DetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSETop20DetailEntity> nseTop20DetailEntities = new ArrayList<>();
        if(sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        for (CSVRecord csvRecord : sourceData) {
            NSETop20DetailEntity nseTop20DetailEntity = new NSETop20DetailEntity();
            nseTop20DetailEntity.setTop20Type(this.top20Type);
            nseTop20DetailEntity.setTop20SubType(this.top20SubType);

            String symbol = csvRecord.get(0).trim();
            nseTop20DetailEntity.setSymbol(symbol);
            try {
                nseTop20DetailEntity.setOpenPrice(Double.parseDouble(csvRecord.get(1).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("OpenPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setHighPrice(Double.parseDouble(csvRecord.get(2).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("HighPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setLowPrice(Double.parseDouble(csvRecord.get(3).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LowPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setPreviousClosePrice(Double.parseDouble(csvRecord.get(4).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClosePrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setLastTradedPrice(Double.parseDouble(csvRecord.get(5).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LastTradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setPercentageChange(Double.parseDouble(csvRecord.get(6).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setVolumeInShares(Integer.parseInt(csvRecord.get(7).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("VolumeInShares of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setValueInLakhs(Double.parseDouble(csvRecord.get(8).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("ValueInLakhs of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()));
            }
            try {
                nseTop20DetailEntity.setCA(simpleDateFormat.parse(csvRecord.get(9).trim()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, String.format("CA of %s has raised ParseException(%s)", symbol, parseException.getMessage()));
            }
            nseTop20DetailEntities.add(nseTop20DetailEntity);
        }

        return nseTop20DetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSETop20DetailEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSETop20DetailEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSETop20DetailEntity> nseTop20DetailEntities = new ArrayList<>();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSETop20DetailEntity nseTop20DetailEntity : transformedData) {
            String key = nseTop20DetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseTop20DetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseTop20DetailEntities.add(nseTop20DetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity for(%s) does not exists...hence creating it.", key, nseTop20DetailEntity.getSymbol()));
                NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nseTop20DetailEntity.getSymbol(), null, null, null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
            }
        }
        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nseTop20DetailRepository.bulkUpsert(nseTop20DetailEntities);
    }
}