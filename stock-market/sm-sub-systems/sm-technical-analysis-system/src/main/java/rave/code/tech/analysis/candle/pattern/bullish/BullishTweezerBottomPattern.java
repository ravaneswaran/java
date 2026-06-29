package rave.code.tech.analysis.candle.pattern.bullish;

import rave.code.tech.analysis.candle.pattern.AbstractPattern;
import rave.code.tech.analysis.candle.pattern.Candle;

import java.util.List;

public class BullishTweezerBottomPattern extends AbstractPattern {

    // Allowed low-price difference
    private static final double TOLERANCE = 0.2;

    public BullishTweezerBottomPattern() {
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
    public String getName() {
        return "Bullish Tweezer Bottom";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishTweezerBottomPattern.isTweezerBottom(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}