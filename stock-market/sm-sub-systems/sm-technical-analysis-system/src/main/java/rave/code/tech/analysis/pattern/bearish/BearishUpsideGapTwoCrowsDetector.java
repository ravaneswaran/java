package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishUpsideGapTwoCrowsDetector extends AbstractPatternDetector {

    public BearishUpsideGapTwoCrowsDetector() {
        super(3);
    }

    public static boolean isUpsideGapTwoCrows(Candle c1, Candle c2, Candle c3) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Third candle bearish
        boolean thirdBearish = c3.isBearish();

        // Gap up between first and second
        boolean gapUp = c2.getOpen() > c1.getClose();

        // Third candle opens above second
        boolean opensHigher = c3.getOpen() > c2.getOpen();

        // Third closes below second close
        boolean closesLower = c3.getClose() < c2.getClose();

        // Third closes into gap
        boolean closesIntoGap = c3.getClose() > c1.getClose();

        return firstBullish
                && secondBearish
                && thirdBearish
                && gapUp
                && opensHigher
                && closesLower
                && closesIntoGap;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishUpsideGapTwoCrowsDetector.isUpsideGapTwoCrows(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
