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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NSEXXXMovingAverageDetailEntityMakerJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(NSEXXXMovingAverageDetailEntityMakerJob.class.getName());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
        LOGGER.info("fetching the stock bases...");
        List<NSEStockBaseEntity> nseStockBaseEntities = nseStockBaseRepository.findAll();
        this.processXXXMovingAverage(nseStockBaseEntities);
    }

    public void processXXXMovingAverage(List<NSEStockBaseEntity> nseStockBaseEntities) {

        NSEDayPriceDetailRepository nseDayPriceDetailRepository = new NSEDayPriceDetailRepository();

        List<NSESimpleMovingAverageDetailEntity> nseSimpleMovingAverageDetailEntities = new ArrayList<>();
        List<NSEExponentialMovingAverageDetailEntity> nseExponentialMovingAverageDetailEntities = new ArrayList<>();

        for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {

            String symbol = nseStockBaseEntity.getSymbol();
            String series = nseStockBaseEntity.getSeries();

            LOGGER.info(String.format("fetching day price details for the symbol(%s : %s)", symbol, series));
            List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities = nseDayPriceDetailRepository.findBySymbolAndSeries(symbol, series);

            if (nseDayPriceDetailEntities.size() > 200) {

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

                NSESimpleMovingAverageDetailEntity nseSimpleMovingAverageDetailEntity = new NSESimpleMovingAverageDetailEntity();
                nseSimpleMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseSimpleMovingAverageDetailEntity.setSMA5D(simpleMovingAverageFor5Days);
                nseSimpleMovingAverageDetailEntity.setSMA10D(simpleMovingAverageFor10Days);
                nseSimpleMovingAverageDetailEntity.setSMA20D(simpleMovingAverageFor20Days);
                nseSimpleMovingAverageDetailEntity.setSMA50D(simpleMovingAverageFor50Days);
                nseSimpleMovingAverageDetailEntity.setSMA100D(simpleMovingAverageFor100Days);
                nseSimpleMovingAverageDetailEntity.setSMA200D(simpleMovingAverageFor200Days);

                NSEExponentialMovingAverageDetailEntity nseExponentialMovingAverageDetailEntity = new NSEExponentialMovingAverageDetailEntity();
                nseExponentialMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseExponentialMovingAverageDetailEntity.setEMA5D(exponentialMovingAverageFor5Days);
                nseExponentialMovingAverageDetailEntity.setEMA10D(exponentialMovingAverageFor10Days);
                nseExponentialMovingAverageDetailEntity.setEMA20D(exponentialMovingAverageFor20Days);
                nseExponentialMovingAverageDetailEntity.setEMA50D(exponentialMovingAverageFor50Days);
                nseExponentialMovingAverageDetailEntity.setEMA100D(exponentialMovingAverageFor100Days);
                nseExponentialMovingAverageDetailEntity.setEMA200D(exponentialMovingAverageFor200Days);

                nseSimpleMovingAverageDetailEntities.add(nseSimpleMovingAverageDetailEntity);
                nseExponentialMovingAverageDetailEntities.add(nseExponentialMovingAverageDetailEntity);
            }
        }

        NSESimpleMovingAverageDetailRepository nseSimpleMovingAverageDetailRepository = new NSESimpleMovingAverageDetailRepository();
        nseSimpleMovingAverageDetailRepository.bulkUpsert(nseSimpleMovingAverageDetailEntities);

        NSEExponentialMovingAverageDetailRepository nseExponentialMovingAverageDetailRepository = new NSEExponentialMovingAverageDetailRepository();
        nseExponentialMovingAverageDetailRepository.bulkUpsert(nseExponentialMovingAverageDetailEntities);
    }

    private double calculateSimpleMovingAverage(List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities) {
        double simpleMovingAverage = 0.0;
        for (NSEDayPriceDetailEntity nseDayPriceDetailEntity : nseDayPriceDetailEntities) {
            simpleMovingAverage += Double.valueOf(nseDayPriceDetailEntity.getClosePrice());
        }
        return simpleMovingAverage / nseDayPriceDetailEntities.size();
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

        return (todayClosePrice * multiplier) + (simpleMovingAverage * multiplier);
    }

    public static void main(String[] args) {
        NSEXXXMovingAverageDetailEntityMakerJob nseXXXMovingAverageDetailEntityMakerJob = new NSEXXXMovingAverageDetailEntityMakerJob();
        try {
            nseXXXMovingAverageDetailEntityMakerJob.execute(null);
        } catch (JobExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}