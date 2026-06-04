package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishThreeBlackCrowsDetector extends AbstractPatternDetector {

    public BearishThreeBlackCrowsDetector() {
        super(3);
    }

    public static boolean isThreeBlackCrows(Candle c1, Candle c2, Candle c3) {
        // All candles must be bearish
        boolean allBearish = c1.isBearish() && c2.isBearish() && c3.isBearish();

        // Consecutively lower closes
        boolean lowerCloses = c2.getClose() < c1.getClose() && c3.getClose() < c2.getClose();

        // Opens within previous body
        boolean properOpens = c2.getOpen() < c1.getOpen() && c2.getOpen() > c1.getClose() && c3.getOpen() < c2.getOpen() && c3.getOpen() > c2.getClose();

        return allBearish && lowerCloses && properOpens;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishThreeBlackCrowsDetector.isThreeBlackCrows(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
