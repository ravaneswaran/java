package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishEveningStarDetector extends AbstractPatternDetector {

    public BearishEveningStarDetector(){
        super(3);
    }

    public static boolean isEveningStar(Candle c1, Candle c2, Candle c3) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Small middle candle
        boolean smallStar = c2.bodySize() < c1.bodySize() * 0.5;

        // Third candle bearish
        boolean thirdBearish = c3.isBearish();

        // Midpoint of first candle
        double midpoint = (c1.getOpen() + c1.getClose()) / 2.0;

        // Third candle closes below midpoint
        boolean deepClose = c3.getClose() < midpoint;

        return firstBullish
                && smallStar
                && thirdBearish
                && deepClose;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishEveningStarDetector.isEveningStar(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
