package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishDarkCloudCoverPattern extends AbstractPattern {

    public BearishDarkCloudCoverPattern() {
        super(2);
    }

    public static boolean isDarkCloudCover(Candle c1, Candle c2) {
        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Gap up opening
        boolean gapUp = c2.getOpen() > c1.getClose();

        // Midpoint of first candle
        double midpoint = (c1.getOpen() + c1.getClose()) / 2.0;

        // Close below midpoint
        boolean deepPenetration = c2.getClose() < midpoint;

        // Not a bearish engulfing
        boolean notEngulfing = c2.getClose() > c1.getOpen();

        return firstBullish
                && secondBearish
                && gapUp
                && deepPenetration
                && notEngulfing;
    }

    @Override
    public String getName() {
        return "Bearish Dark Cloud Cover";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishDarkCloudCoverPattern.isDarkCloudCover(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
