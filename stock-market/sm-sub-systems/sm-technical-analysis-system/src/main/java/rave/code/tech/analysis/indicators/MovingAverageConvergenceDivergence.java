package rave.code.tech.analysis.indicators;

import java.util.List;

public class MovingAverageConvergenceDivergence {

    public double[] calculate(List<Double> prices, int fastPeriod, int slowPeriod) {
        double[] fastEma = calculateEMA(prices, fastPeriod);
        double[] slowEma = calculateEMA(prices, slowPeriod);

        double[] macd = new double[prices.size()];

        for (int i = 0; i < prices.size(); i++) {
            macd[i] = fastEma[i] - slowEma[i];
        }

        return macd;
    }

    private double[] calculateEMA(List<Double> prices, int period) {
        return null;
    }
}
