package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishSeparatingLinesDetector extends AbstractPatternDetector {

    // Allow small price differences
    private static final double TOLERANCE = 0.20;

    public BullishSeparatingLinesDetector() {
        super(2);
    }

    public static boolean isSeparatingLines(Candle c1, Candle c2) {
        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Nearly identical opens
        boolean sameOpen = Math.abs(c1.getOpen() - c2.getOpen()) <= TOLERANCE;

        // Strong bullish continuation
        boolean breakout = c2.getClose() > c1.getHigh();

        return firstBearish && secondBullish && sameOpen && breakout;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishSeparatingLinesDetector.isSeparatingLines(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
