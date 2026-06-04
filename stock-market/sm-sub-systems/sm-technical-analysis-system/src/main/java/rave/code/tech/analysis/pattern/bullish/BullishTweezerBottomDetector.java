package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishTweezerBottomDetector extends AbstractPatternDetector {

    // Allowed low-price difference
    private static final double TOLERANCE = 0.2;

    public BullishTweezerBottomDetector() {
        super(2);
    }

    public static boolean isTweezerBottom(Candle c1, Candle c2) {
        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Nearly equal lows
        boolean sameLow = Math.abs(c1.getLow() - c2.getLow()) <= TOLERANCE;

        return firstBearish && secondBullish && sameLow;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishTweezerBottomDetector.isTweezerBottom(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}