package rave.code.tech.analysis.average;

import java.util.List;

public class SimpleMovingAverage {

    private List<LastTradedPrice> lastTradedPrices;
    private int period;

    public SimpleMovingAverage(List<LastTradedPrice> lastTradedPrices) {
        this.lastTradedPrices = lastTradedPrices;
        this.period = 5;
    }

    public SimpleMovingAverage(List<LastTradedPrice> lastTradedPrices, int period) {
        this.lastTradedPrices = lastTradedPrices;
        this.period = period;
    }

    public double getValue() {
        if (null != this.lastTradedPrices) {
            int size = this.lastTradedPrices.size();
            List<LastTradedPrice> tempList = null;
            if (size > this.period) {
                int startIndex = size - this.period;
                tempList = this.lastTradedPrices.subList(startIndex, size);
            } else {
                tempList = this.lastTradedPrices;
            }
            double sum = 0;
            for (LastTradedPrice lastTradedPrice : tempList) {
                sum += lastTradedPrice.getValue();
            }
            return sum / tempList.size();
        } else {
            return 0;
        }
    }
}
