package rave.code.tech.analysis.indicators;

import rave.code.tech.analysis.Candle;

import java.util.List;

public class VolumeWeightedAveragePrice {

    public Double calculate(List<Candle> candles) {
        double cumulativePV = 0.0;
        long cumulativeVolume = 0;
        for (Candle candle : candles) {
            double typicalPrice =
                    (candle.getHighPrice()
                            + candle.getLowPrice()
                            + candle.getClosePrice()) / 3.0;

            cumulativePV += typicalPrice * candle.getVolume();
            cumulativeVolume += candle.getVolume();
        }
        if (cumulativeVolume == 0) {
            return 0.0;
        }
        return cumulativePV / cumulativeVolume;
    }
}
