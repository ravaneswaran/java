package rave.code.quartz.jobs.nse.csv.live.mainboard;

import org.apache.commons.csv.CSVRecord;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSEMainBoardDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.quartz.jobs.nse.csv.live.AbstractNSELiveMarketEntityMakerJob;
import rave.code.repository.nse.NSEMainBoardDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEMainBoardDetailEntityMakerJob extends AbstractNSELiveMarketEntityMakerJob<List<NSEMainBoardDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEMainBoardDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEMainBoardDetailRepository nseMainBoardDetailRepository = new NSEMainBoardDetailRepository();

    public NSEMainBoardDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-most-active-securities?index=value&csv=true");
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        return this.getDataFromSource(true);
    }

    @Override
    public List<NSEMainBoardDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEMainBoardDetailEntity> nseMainBoardDetailEntities = new ArrayList<>();
        if(sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        for (CSVRecord csvRecord : sourceData) {
            NSEMainBoardDetailEntity nseMainBoardDetailEntity = new NSEMainBoardDetailEntity();

            String symbol = csvRecord.get(0).trim();
            nseMainBoardDetailEntity.setSymbol(symbol);
            try {
                nseMainBoardDetailEntity.setOpenPrice(Double.parseDouble(csvRecord.get(1).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("OpenPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setHighPrice(Double.parseDouble(csvRecord.get(2).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("HighPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setLowPrice(Double.parseDouble(csvRecord.get(3).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LowPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setPreviousClosePrice(Double.parseDouble(csvRecord.get(4).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClosePrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setLastTradedPrice(Double.parseDouble(csvRecord.get(5).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LastTradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setPercentageChange(Double.parseDouble(csvRecord.get(6).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setVolumeInShares(Integer.parseInt(csvRecord.get(7).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("VolumeInShares of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setValueInLakhs(Double.parseDouble(csvRecord.get(8).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("ValueInLakhs of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseMainBoardDetailEntity.setCA(simpleDateFormat.parse(csvRecord.get(9).trim()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, String.format("CA of %s has raised ParseException(%s)", symbol, parseException.getMessage()), parseException);
            }
            nseMainBoardDetailEntities.add(nseMainBoardDetailEntity);
        }

        return nseMainBoardDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEMainBoardDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSEMainBoardDetailEntity> nseMainBoardDetailEntities = new ArrayList<>();

        for (NSEMainBoardDetailEntity nseMainBoardDetailEntity : transformedData) {
            String key = nseMainBoardDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseMainBoardDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseMainBoardDetailEntities.add(nseMainBoardDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity not for(%s) exists...", key, nseMainBoardDetailEntity.getSymbol()));
            }
        }
        this.nseMainBoardDetailRepository.bulkUpsert(nseMainBoardDetailEntities);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSEMainBoardDetailEntityMakerJob nseMainBoardDetailEntityMakerJob = new NSEMainBoardDetailEntityMakerJob();
        nseMainBoardDetailEntityMakerJob.saveTransformedData(nseMainBoardDetailEntityMakerJob.transformSourceData(nseMainBoardDetailEntityMakerJob.getDataFromSource()));
    }
}
