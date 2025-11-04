package rave.code.tech.analysis.indicators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SimpleMovingAverageIndicator {

    // Method to calculate SMA
    public static List<Double> calculateSMA(List<Double> prices, int period) {
        List<Double> simpleMovingAverage = new ArrayList<>();
        if (prices == null || prices.size() < period) {
            return simpleMovingAverage; // Not enough data
        }
        double sum = 0.0;
        for (int index = 0; index < prices.size(); index++) {
            sum += prices.get(index);
            if (index >= period - 1) {
                if (index >= period) {
                    sum -= prices.get(index - period);
                }
                simpleMovingAverage.add(sum / period);
            }
        }
        return simpleMovingAverage;
    }

    public static void main(String[] args) {
        // Example closing prices
        List<Double> prices = Arrays.asList(22.0, 24.5, 25.0, 23.5, 26.0, 27.5, 28.0, 29.5, 30.0);

        // SMA for 3-day period
        int period = 3;
        List<Double> smaValues = calculateSMA(prices, period);
        System.out.println("SMA (" + period + "-day): " + smaValues);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date testDate = new Date(1755166320000l);
        System.out.println("--------------->>>>>> "+simpleDateFormat.format(testDate));
    }
}
