package rave.code.tech.analysis.candle.pattern.bearish;

import rave.code.tech.analysis.candle.pattern.AbstractPattern;
import rave.code.tech.analysis.candle.pattern.Candle;

import java.util.List;

public class BearishTweezerTopPattern extends AbstractPattern {

    // Allow small price differences
    private static final double TOLERANCE = 0.20;

    public BearishTweezerTopPattern() {
        super(2);
    }

    public static boolean isTweezerTop(Candle c1, Candle c2) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();
        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Nearly equal highs
        boolean matchingHighs = Math.abs(c1.getHigh() - c2.getHigh()) <= TOLERANCE;

        return firstBullish && secondBearish && matchingHighs;
    }

    @Override
    public String getName() {
        return "Bearish Tweezer Top";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishTweezerTopPattern.isTweezerTop(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
