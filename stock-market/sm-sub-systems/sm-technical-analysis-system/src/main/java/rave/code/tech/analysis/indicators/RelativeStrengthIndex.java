package rave.code.tech.analysis.indicators;

import rave.code.tech.analysis.Candle;

import java.util.List;

public class RelativeStrengthIndex {

    public double calculate(List<Candle> candles, int period) {
        if (candles.size() <= period) {
            throw new IllegalArgumentException("Need more than " + period + " closing prices");
        }
        double gain = 0;
        double loss = 0;
        // First average gain/loss
        for (int i = 1; i <= period; i++) {
            double change = candles.get(i).getClosePrice() - candles.get(i - 1).getClosePrice();
            if (change > 0) {
                gain += change;
            } else {
                loss -= change;
            }
        }
        double avgGain = gain / period;
        double avgLoss = loss / period;
        if (avgLoss == 0) {
            return 100.0;
        }
        double rs = avgGain / avgLoss;

        return 100.0 - (100.0 / (1.0 + rs));
    }
}
