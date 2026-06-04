package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishMatHoldDetector extends AbstractPatternDetector {

    public BearishMatHoldDetector() {
        super(5);
    }

    public static boolean isMatHold(Candle c1, Candle c2, Candle c3, Candle c4, Candle c5) {

        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Middle candles small
        boolean smallMiddleCandles = c2.bodySize() < c1.bodySize() * 0.5
                && c3.bodySize() < c1.bodySize() * 0.5
                && c4.bodySize() < c1.bodySize() * 0.5;

        // Middle candles remain inside first candle range
        boolean insideRange = c2.getHigh() <= c1.getHigh()
                && c3.getHigh() <= c1.getHigh()
                && c4.getHigh() <= c1.getHigh();

        // Final candle bearish
        boolean fifthBearish = c5.isBearish();

        // Continuation confirmation
        boolean breakdown = c5.getClose() < c1.getClose();

        return firstBearish
                && smallMiddleCandles
                && insideRange
                && fifthBearish
                && breakdown;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishMatHoldDetector.isMatHold(candles.get(0), candles.get(1), candles.get(2), candles.get(3), candles.get(4));
        } else {
            return false;
        }
    }
}
