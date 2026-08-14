package rave.code.quartz.jobs.nse.histories;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.histories.NSEPreOpenMarketDetailHistoryEntity;
import rave.code.quartz.jobs.AbstractQuartzJob;
import rave.code.repository.nse.NSEPreOpenMarketDetailHistoryRepository;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPreOpenMarketDetailHistoryEntityMakerJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(NSEPreOpenMarketDetailHistoryEntityMakerJob.class.getName());

    @Override
    public void executeJob(JobExecutionContext context) throws JobExecutionException {
        NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();
        NSEPreOpenMarketDetailHistoryRepository nsePreOpenMarketDetailHistoryRepository = new NSEPreOpenMarketDetailHistoryRepository();
        Date today = getDate();
        List<NSEPreOpenMarketDetailEntity> nsePreOpenMarketDetailEntities = nsePreOpenMarketDetailRepository.findEntitiesOnADay(today);
        List<NSEPreOpenMarketDetailHistoryEntity> historyEntities = new ArrayList<>();
        LOGGER.info(String.format("Total number of symbol is %s...", nsePreOpenMarketDetailEntities.size()));
        int size = nsePreOpenMarketDetailEntities.size();
        int startIndex = 0;
        int endIndex = 1;
        for (; endIndex < size; endIndex++) {
            NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntityOne = nsePreOpenMarketDetailEntities.get(startIndex);
            NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntityTwo = nsePreOpenMarketDetailEntities.get(endIndex);
            if (nsePreOpenMarketDetailEntityOne.getSymbol().equals(nsePreOpenMarketDetailEntityTwo.getSymbol())) {
                continue;
            }
            addHistories(historyEntities, nsePreOpenMarketDetailEntities, startIndex, endIndex);
            startIndex = endIndex;
        }
        addHistories(historyEntities, nsePreOpenMarketDetailEntities, startIndex, endIndex);
        nsePreOpenMarketDetailHistoryRepository.bulkUpsert(historyEntities);
    }

    private static void addHistories(List<NSEPreOpenMarketDetailHistoryEntity> historyEntities, List<NSEPreOpenMarketDetailEntity> nsePreOpenMarketDetailEntities, int startIndex, int endIndex) {
        List<NSEPreOpenMarketDetailEntity> nsePreOpenMarketDetailEntitiesSubList = nsePreOpenMarketDetailEntities.subList(startIndex, endIndex);
        NSEPreOpenMarketDetailEntity firstInstance = nsePreOpenMarketDetailEntitiesSubList.getFirst();
        NSEPreOpenMarketDetailEntity lastInstance = nsePreOpenMarketDetailEntitiesSubList.getLast();
        NSEStockBaseEntity nseStockBaseEntity = firstInstance.getNseStockBaseEntity();
        NSEPreOpenMarketDetailHistoryEntity nsePreOpenMarketDetailHistoryEntity = createNSEPreOpenMarketDetailHistoryEntity(nseStockBaseEntity, firstInstance, lastInstance);
        historyEntities.add(nsePreOpenMarketDetailHistoryEntity);
    }

    private static Date getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse("2026-08-13");
        } catch (ParseException e) {
            return new Date();
        }
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
