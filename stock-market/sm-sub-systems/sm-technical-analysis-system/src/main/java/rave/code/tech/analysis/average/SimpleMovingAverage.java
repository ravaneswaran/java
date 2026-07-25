package rave.code.tech.analysis.average;

import rave.code.tech.analysis.Candle;

import java.util.List;

public class SimpleMovingAverage {

    private List<Candle> candles;
    private int period;

    public SimpleMovingAverage(List<Candle> candles) {
        this.candles = candles;
        this.period = 5;
    }

    public SimpleMovingAverage(List<Candle> candles, int period) {
        this.candles = candles;
        this.period = period;
    }

    public double getValue() {
        if (null != this.candles) {
            int size = this.candles.size();
            List<Candle> tempList = null;
            if (size > this.period) {
                int startIndex = size - this.period;
                tempList = this.candles.subList(startIndex, size);
            } else {
                tempList = this.candles;
            }
            double sum = 0;
            for (Candle candle : tempList) {
                sum += candle.getLastTradedPrice();
            }
            return sum / tempList.size();
        } else {
            return 0;
        }
    }

    /*public static void main(String[] args) {
        // Example closing prices
        List<Double> prices = Arrays.asList(22.0, 24.5, 25.0, 23.5, 26.0, 27.5, 28.0, 29.5, 30.0);
        // SMA for 3-day period
        int period = 3;

        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(prices, period);


        List<Double> smaValues = calculateSMA(prices, period);
        System.out.println("SMA (" + period + "-day): " + smaValues);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date testDate = new Date(1755166320000l);
        System.out.println("--------------->>>>>> "+simpleDateFormat.format(testDate));
    }*/
}
