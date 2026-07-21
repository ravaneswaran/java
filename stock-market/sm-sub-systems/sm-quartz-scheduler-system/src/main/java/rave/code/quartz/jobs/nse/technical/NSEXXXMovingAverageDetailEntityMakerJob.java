package rave.code.quartz.jobs.nse.technical;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSEDayPriceDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.technical.NSEExponentialMovingAverageDetailEntity;
import rave.code.entity.nse.technical.NSESimpleMovingAverageDetailEntity;
import rave.code.quartz.jobs.AbstractQuartzJob;
import rave.code.repository.nse.NSEDayPriceDetailRepository;
import rave.code.repository.nse.NSEExponentialMovingAverageDetailRepository;
import rave.code.repository.nse.NSESimpleMovingAverageDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class NSEXXXMovingAverageDetailEntityMakerJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(NSEXXXMovingAverageDetailEntityMakerJob.class.getName());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        this.processXXXMovingAverage();
    }

    public void processXXXMovingAverage() {
        NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
        NSEDayPriceDetailRepository nseDayPriceDetailRepository = new NSEDayPriceDetailRepository();
        NSESimpleMovingAverageDetailRepository nseSimpleMovingAverageDetailRepository = new NSESimpleMovingAverageDetailRepository();
        NSEExponentialMovingAverageDetailRepository nseExponentialMovingAverageDetailRepository = new NSEExponentialMovingAverageDetailRepository();


        List<NSEStockBaseEntity> nseStockBaseEntities = nseStockBaseRepository.findAll();
        for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {
            String symbol = nseStockBaseEntity.getSymbol();
            try (Stream<NSEDayPriceDetailEntity> nseDayPriceDetailStream = nseDayPriceDetailRepository.findEquitiesForSymbol(symbol)) {
                List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities = nseDayPriceDetailStream.toList();
                int size = nseDayPriceDetailEntities.size();

                if (size >= 200) {

                    List<NSEDayPriceDetailEntity> nseDayPriceDetailEntityFor5Days = nseDayPriceDetailEntities.subList(0, 5);
                    List<NSEDayPriceDetailEntity> nseDayPriceDetailEntityFor10Days = nseDayPriceDetailEntities.subList(0, 10);
                    List<NSEDayPriceDetailEntity> nseDayPriceDetailEntityFor20Days = nseDayPriceDetailEntities.subList(0, 20);
                    List<NSEDayPriceDetailEntity> nseDayPriceDetailEntityFor50Days = nseDayPriceDetailEntities.subList(0, 50);
                    List<NSEDayPriceDetailEntity> nseDayPriceDetailEntityFor100Days = nseDayPriceDetailEntities.subList(0, 100);
                    List<NSEDayPriceDetailEntity> nseDayPriceDetailEntityFor200Days = nseDayPriceDetailEntities.subList(0, 200);

                    double simpleMovingAverageFor5Days = this.calculateSimpleMovingAverage(nseDayPriceDetailEntityFor5Days);
                    double simpleMovingAverageFor10Days = this.calculateSimpleMovingAverage(nseDayPriceDetailEntityFor10Days);
                    double simpleMovingAverageFor20Days = this.calculateSimpleMovingAverage(nseDayPriceDetailEntityFor20Days);
                    double simpleMovingAverageFor50Days = this.calculateSimpleMovingAverage(nseDayPriceDetailEntityFor50Days);
                    double simpleMovingAverageFor100Days = this.calculateSimpleMovingAverage(nseDayPriceDetailEntityFor100Days);
                    double simpleMovingAverageFor200Days = this.calculateSimpleMovingAverage(nseDayPriceDetailEntityFor200Days);

                    double exponentialMovingAverageFor5Days = this.calculateExponentialMovingAverage(nseDayPriceDetailEntityFor5Days);
                    double exponentialMovingAverageFor10Days = this.calculateExponentialMovingAverage(nseDayPriceDetailEntityFor10Days);
                    double exponentialMovingAverageFor20Days = this.calculateExponentialMovingAverage(nseDayPriceDetailEntityFor20Days);
                    double exponentialMovingAverageFor50Days = this.calculateExponentialMovingAverage(nseDayPriceDetailEntityFor50Days);
                    double exponentialMovingAverageFor100Days = this.calculateExponentialMovingAverage(nseDayPriceDetailEntityFor100Days);
                    double exponentialMovingAverageFor200Days = this.calculateExponentialMovingAverage(nseDayPriceDetailEntityFor200Days);

                    NSESimpleMovingAverageDetailEntity nseSimpleMovingAverageDetailEntity = nseSimpleMovingAverageDetailRepository.findByForeignKey(nseStockBaseEntity.getId());
                    if (null == nseSimpleMovingAverageDetailEntity) {
                        LOGGER.info(String.format("creating a new Simple Moving Average for the stock %s", nseStockBaseEntity.getSymbol()));
                        nseSimpleMovingAverageDetailEntity = new NSESimpleMovingAverageDetailEntity();
                        nseSimpleMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                    } else {
                        String.format("updating the old Simple Moving Average for the stock %s", nseStockBaseEntity.getSymbol());
                        nseSimpleMovingAverageDetailEntity.setNewEntity(false);
                        nseSimpleMovingAverageDetailEntity.setModifiedDate(new Date());
                    }
                    nseSimpleMovingAverageDetailEntity.setSMA5D(simpleMovingAverageFor5Days);
                    nseSimpleMovingAverageDetailEntity.setSMA10D(simpleMovingAverageFor10Days);
                    nseSimpleMovingAverageDetailEntity.setSMA20D(simpleMovingAverageFor20Days);
                    nseSimpleMovingAverageDetailEntity.setSMA50D(simpleMovingAverageFor50Days);
                    nseSimpleMovingAverageDetailEntity.setSMA100D(simpleMovingAverageFor100Days);
                    nseSimpleMovingAverageDetailEntity.setSMA200D(simpleMovingAverageFor200Days);

                    NSEExponentialMovingAverageDetailEntity nseExponentialMovingAverageDetailEntity = nseExponentialMovingAverageDetailRepository.findByForeignKey(nseStockBaseEntity.getId());
                    if (null == nseExponentialMovingAverageDetailEntity) {
                        LOGGER.info(String.format("creating a new Exponential Moving Average for the stock %s", nseStockBaseEntity.getSymbol()));
                        nseExponentialMovingAverageDetailEntity = new NSEExponentialMovingAverageDetailEntity();
                        nseExponentialMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                    } else {
                        String.format("updating the old Exponential Moving Average for the stock %s", nseStockBaseEntity.getSymbol());
                        nseExponentialMovingAverageDetailEntity.setNewEntity(false);
                        nseExponentialMovingAverageDetailEntity.setModifiedDate(new Date());
                    }
                    nseExponentialMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                    nseExponentialMovingAverageDetailEntity.setEMA5D(exponentialMovingAverageFor5Days);
                    nseExponentialMovingAverageDetailEntity.setEMA10D(exponentialMovingAverageFor10Days);
                    nseExponentialMovingAverageDetailEntity.setEMA20D(exponentialMovingAverageFor20Days);
                    nseExponentialMovingAverageDetailEntity.setEMA50D(exponentialMovingAverageFor50Days);
                    nseExponentialMovingAverageDetailEntity.setEMA100D(exponentialMovingAverageFor100Days);
                    nseExponentialMovingAverageDetailEntity.setEMA200D(exponentialMovingAverageFor200Days);

                    nseSimpleMovingAverageDetailRepository.upsert(nseSimpleMovingAverageDetailEntity);
                    nseExponentialMovingAverageDetailRepository.upsert(nseExponentialMovingAverageDetailEntity);
                }
            }
        }
    }

    private double calculateSimpleMovingAverage(List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities) {
        double simpleMovingAverage = 0.0;
        for (NSEDayPriceDetailEntity nseDayPriceDetailEntity : nseDayPriceDetailEntities) {
            simpleMovingAverage += Double.valueOf(nseDayPriceDetailEntity.getClosePrice());
        }
        return Math.round((simpleMovingAverage / nseDayPriceDetailEntities.size()) * 100.0) / 100.0;
    }

    private double calculateExponentialMovingAverage(List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities) {
        int period = nseDayPriceDetailEntities.size();
        double multiplier = 2.0 / (period + 1);

        double simpleMovingAverage = 0.0;
        for (int index = 0; index < period - 1; index++) {
            double closePrice = Double.parseDouble(nseDayPriceDetailEntities.get(index).getClosePrice());
            simpleMovingAverage += closePrice;
        }
        simpleMovingAverage /= period;
        double todayClosePrice = Double.parseDouble(nseDayPriceDetailEntities.getLast().getClosePrice());

        return Math.round(((todayClosePrice * multiplier) + (simpleMovingAverage * multiplier)) * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
        NSEXXXMovingAverageDetailEntityMakerJob nseXXXMovingAverageDetailEntityMakerJob = new NSEXXXMovingAverageDetailEntityMakerJob();
        try {
            nseXXXMovingAverageDetailEntityMakerJob.execute(null);
        } catch (JobExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}