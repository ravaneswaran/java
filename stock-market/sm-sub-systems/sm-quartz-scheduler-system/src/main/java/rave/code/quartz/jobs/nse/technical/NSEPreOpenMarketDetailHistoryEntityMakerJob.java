package rave.code.quartz.jobs.nse.technical;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.histories.NSEPreOpenMarketDetailHistoryEntity;
import rave.code.quartz.jobs.AbstractQuartzJob;
import rave.code.repository.nse.NSEPreOpenMarketDetailHistoryRepository;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPreOpenMarketDetailHistoryEntityMakerJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(NSEPreOpenMarketDetailHistoryEntityMakerJob.class.getName());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();
        NSEPreOpenMarketDetailHistoryRepository nsePreOpenMarketDetailHistoryRepository = new NSEPreOpenMarketDetailHistoryRepository();
        Date today = new Date();
        List<String> symbolList = nsePreOpenMarketDetailRepository.findDistinctSymbolsOnADay(today);
        LOGGER.info(String.format("Total number of symbol is %s...", symbolList.size()));

        List<NSEPreOpenMarketDetailHistoryEntity> entites = new ArrayList<>();
        for (String symbol : symbolList) {
            List<NSEPreOpenMarketDetailEntity> nsePreOpenMarketDetailEntities = nsePreOpenMarketDetailRepository.findBySymbolOnADay(symbol, today);

            NSEPreOpenMarketDetailEntity firstInstance = nsePreOpenMarketDetailEntities.getFirst();
            NSEPreOpenMarketDetailEntity lastInstance = nsePreOpenMarketDetailEntities.getLast();
            NSEStockBaseEntity nseStockBaseEntity = firstInstance.getNseStockBaseEntity();

            NSEPreOpenMarketDetailHistoryEntity nsePreOpenMarketDetailHistoryEntity = createNSEPreOpenMarketDetailHistoryEntity(nseStockBaseEntity, firstInstance, lastInstance);
            entites.add(nsePreOpenMarketDetailHistoryEntity);
        }
        nsePreOpenMarketDetailHistoryRepository.bulkUpsert(entites);
    }

    private static NSEPreOpenMarketDetailHistoryEntity createNSEPreOpenMarketDetailHistoryEntity(NSEStockBaseEntity nseStockBaseEntity, NSEPreOpenMarketDetailEntity firstInstance, NSEPreOpenMarketDetailEntity lastInstance) {
        NSEPreOpenMarketDetailHistoryEntity nsePreOpenMarketDetailHistoryEntity = new NSEPreOpenMarketDetailHistoryEntity();
        nsePreOpenMarketDetailHistoryEntity.setNseStockBaseEntity(nseStockBaseEntity);
        nsePreOpenMarketDetailHistoryEntity.setBusinessDate(firstInstance.getBusinessDate());
        nsePreOpenMarketDetailHistoryEntity.setPreOpenType(firstInstance.getPreOpenType());
        nsePreOpenMarketDetailHistoryEntity.setSymbol(firstInstance.getSymbol());
        nsePreOpenMarketDetailHistoryEntity.setPreviousClose(firstInstance.getPreviousClose());
        nsePreOpenMarketDetailHistoryEntity.setIndicativeEquilibriumPriceOfFirstInstance(firstInstance.getIndicativeEquilibriumPrice());
        nsePreOpenMarketDetailHistoryEntity.setIndicativeEquilibriumPriceOfLastInstance(lastInstance.getIndicativeEquilibriumPrice());
        nsePreOpenMarketDetailHistoryEntity.setPricePercentageChangeOfFirstInstance(firstInstance.getPricePercentageChange());
        nsePreOpenMarketDetailHistoryEntity.setPricePercentageChangeOfLastInstance(lastInstance.getPricePercentageChange());
        nsePreOpenMarketDetailHistoryEntity.setPriceChangeOfFirstInstance(firstInstance.getPriceChange());
        nsePreOpenMarketDetailHistoryEntity.setPriceChangeOfLastInstance(lastInstance.getPriceChange());
        nsePreOpenMarketDetailHistoryEntity.setFinalPrice(lastInstance.getFinalPrice());
        nsePreOpenMarketDetailHistoryEntity.setFinalQuantity(lastInstance.getFinalQuantity());
        nsePreOpenMarketDetailHistoryEntity.setValueInCrores(lastInstance.getValueInCrores());
        nsePreOpenMarketDetailHistoryEntity.setFreeFloatMarketCapitalization(lastInstance.getFreeFloatMarketCapitalization());
        nsePreOpenMarketDetailHistoryEntity.setNewMarket52WeekHigh(lastInstance.getNewMarket52WeekHigh());
        nsePreOpenMarketDetailHistoryEntity.setNewMarket52WeekLow(lastInstance.getNewMarket52WeekLow());
        return nsePreOpenMarketDetailHistoryEntity;
    }

    public static void main(String[] args) {
        NSEPreOpenMarketDetailHistoryEntityMakerJob nsePreOpenMarketDetailHistoryEntityMakerJob = new NSEPreOpenMarketDetailHistoryEntityMakerJob();
        try {
            nsePreOpenMarketDetailHistoryEntityMakerJob.execute(null);
        } catch (JobExecutionException jobExecutionException) {
           LOGGER.log(Level.SEVERE, jobExecutionException.getMessage(), jobExecutionException);
        }
    }
}
