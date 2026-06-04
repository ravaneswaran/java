package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishThreeOutsideDownDetector extends AbstractPatternDetector {

    public BearishThreeOutsideDownDetector() {
        super(3);
    }

    public static boolean isThreeOutsideDown(Candle c1, Candle c2, Candle c3) {
        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Third candle bearish
        boolean thirdBearish = c3.isBearish();

        // Bearish engulfing
        boolean engulfing = c2.getOpen() > c1.getClose()
                        && c2.getClose() < c1.getOpen();

        // Confirmation candle
        boolean confirmation = c3.getClose() < c2.getClose();

        return firstBullish
                && secondBearish
                && thirdBearish
                && engulfing
                && confirmation;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishThreeOutsideDownDetector.isThreeOutsideDown(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
