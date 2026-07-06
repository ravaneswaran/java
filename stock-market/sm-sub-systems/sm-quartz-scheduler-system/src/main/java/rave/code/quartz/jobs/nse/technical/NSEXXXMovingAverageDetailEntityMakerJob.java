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

public class NSEXXXMovingAverageDetailEntityMakerJob extends AbstractQuartzJob {

    private final NSEDayPriceDetailRepository nseDayPriceDetailRepository = new NSEDayPriceDetailRepository();
    private final  NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        List<NSEStockBaseEntity> nseStockBaseEntities = this.nseStockBaseRepository.findAll();
        this.processSimpleMovingAverage(nseStockBaseEntities);
        this.processExponentialMovingAverage(nseStockBaseEntities);
    }

    public void processSimpleMovingAverage(List<NSEStockBaseEntity> nseStockBaseEntities){
        List<NSESimpleMovingAverageDetailEntity> results = new ArrayList<>();

        for(NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities){
            String symbol = nseStockBaseEntity.getSymbol();
            String series = nseStockBaseEntity.getSeries();
            List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities =  this.nseDayPriceDetailRepository.findBySymbolAndSeries(symbol, series);
            if(nseDayPriceDetailEntities.size() > 200) {

                List<NSEDayPriceDetailEntity> sma5dList = nseDayPriceDetailEntities.subList(0, 5);
                List<NSEDayPriceDetailEntity> sma10dList = nseDayPriceDetailEntities.subList(0, 10);
                List<NSEDayPriceDetailEntity> sma20dList = nseDayPriceDetailEntities.subList(0, 20);
                List<NSEDayPriceDetailEntity> sma50dList = nseDayPriceDetailEntities.subList(0, 50);
                List<NSEDayPriceDetailEntity> sma100dList = nseDayPriceDetailEntities.subList(0, 100);
                List<NSEDayPriceDetailEntity> sma200dList = nseDayPriceDetailEntities.subList(0, 200);

                double sma5d = this.calculateSMA(sma5dList);
                double sma10d = this.calculateSMA(sma10dList);
                double sma20d = this.calculateSMA(sma20dList);
                double sma50d = this.calculateSMA(sma50dList);
                double sma100d = this.calculateSMA(sma100dList);
                double sma200d = this.calculateSMA(sma200dList);

                NSESimpleMovingAverageDetailEntity nseSimpleMovingAverageDetailEntity = new NSESimpleMovingAverageDetailEntity();
                nseSimpleMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseSimpleMovingAverageDetailEntity.setSMA5D(sma5d);
                nseSimpleMovingAverageDetailEntity.setSMA10D(sma10d);
                nseSimpleMovingAverageDetailEntity.setSMA20D(sma20d);
                nseSimpleMovingAverageDetailEntity.setSMA50D(sma50d);
                nseSimpleMovingAverageDetailEntity.setSMA100D(sma100d);
                nseSimpleMovingAverageDetailEntity.setSMA200D(sma200d);

                results.add(nseSimpleMovingAverageDetailEntity);
            }
        }

        NSESimpleMovingAverageDetailRepository nseSimpleMovingAverageDetailRepository = new NSESimpleMovingAverageDetailRepository();
        nseSimpleMovingAverageDetailRepository.bulkUpsert(results);
    }

    public void processExponentialMovingAverage(List<NSEStockBaseEntity> nseStockBaseEntities){
        List<NSEExponentialMovingAverageDetailEntity> results = new ArrayList<>();

        for(NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities){
            String symbol = nseStockBaseEntity.getSymbol();
            String series = nseStockBaseEntity.getSeries();
            List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities =  this.nseDayPriceDetailRepository.findBySymbolAndSeries(symbol, series);
            if(nseDayPriceDetailEntities.size() > 200) {

                List<NSEDayPriceDetailEntity> ema5dList = nseDayPriceDetailEntities.subList(0, 5);
                List<NSEDayPriceDetailEntity> ema10dList = nseDayPriceDetailEntities.subList(0, 10);
                List<NSEDayPriceDetailEntity> ema20dList = nseDayPriceDetailEntities.subList(0, 20);
                List<NSEDayPriceDetailEntity> ema50dList = nseDayPriceDetailEntities.subList(0, 50);
                List<NSEDayPriceDetailEntity> ema100dList = nseDayPriceDetailEntities.subList(0, 100);
                List<NSEDayPriceDetailEntity> ema200dList = nseDayPriceDetailEntities.subList(0, 200);

                double ema5d = this.calculateSMA(ema5dList);
                double ema10d = this.calculateEMA(ema10dList);
                double ema20d = this.calculateEMA(ema20dList);
                double ema50d = this.calculateEMA(ema50dList);
                double ema100d = this.calculateEMA(ema100dList);
                double ema200d = this.calculateEMA(ema200dList);

                NSEExponentialMovingAverageDetailEntity nseExponentialMovingAverageDetailEntity = new NSEExponentialMovingAverageDetailEntity();
                nseExponentialMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseExponentialMovingAverageDetailEntity.setEMA5D(ema5d);
                nseExponentialMovingAverageDetailEntity.setEMA10D(ema10d);
                nseExponentialMovingAverageDetailEntity.setEMA20D(ema20d);
                nseExponentialMovingAverageDetailEntity.setEMA50D(ema50d);
                nseExponentialMovingAverageDetailEntity.setEMA100D(ema100d);
                nseExponentialMovingAverageDetailEntity.setEMA200D(ema200d);

                results.add(nseExponentialMovingAverageDetailEntity);
            }
        }

        NSEExponentialMovingAverageDetailRepository nseExponentialMovingAverageDetailRepository = new NSEExponentialMovingAverageDetailRepository();
        nseExponentialMovingAverageDetailRepository.bulkUpsert(results);
    }

    private double calculateSMA(List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities){
        double sma = 0.0;
        for(NSEDayPriceDetailEntity nseDayPriceDetailEntity : nseDayPriceDetailEntities){
            sma += Double.valueOf(nseDayPriceDetailEntity.getClosePrice());
        }
        return sma / nseDayPriceDetailEntities.size();
    }

    private double calculateEMA(List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities){
        double sma = 0.0;
        for(NSEDayPriceDetailEntity nseDayPriceDetailEntity : nseDayPriceDetailEntities){
            sma += Double.valueOf(nseDayPriceDetailEntity.getClosePrice());
        }
        return sma / nseDayPriceDetailEntities.size();
    }

    public static void main(String[] args) {
        NSEXXXMovingAverageDetailEntityMakerJob nseSimpleMovingAverageDetailJob = new NSEXXXMovingAverageDetailEntityMakerJob();
        try {
            nseSimpleMovingAverageDetailJob.execute(null);
        } catch (JobExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}