package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishThreeInsideDownDetector extends AbstractPatternDetector {

    public BearishThreeInsideDownDetector() {
        super(3);
    }

    public static boolean isThreeInsideDown(Candle c1, Candle c2, Candle c3) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Third candle bearish
        boolean thirdBearish = c3.isBearish();

        // Harami condition
        boolean insideBody = c2.getOpen() < c1.getClose()
                        && c2.getOpen() > c1.getOpen()
                        && c2.getClose() < c1.getClose()
                        && c2.getClose() > c1.getOpen();

        // Confirmation candle
        boolean confirmation = c3.getClose() < c2.getClose();

        // Small second candle
        boolean smallSecondBody = c2.bodySize() < c1.bodySize() * 0.5;

        return firstBullish
                && secondBearish
                && thirdBearish
                && insideBody
                && confirmation
                && smallSecondBody;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishThreeInsideDownDetector.isThreeInsideDown(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
