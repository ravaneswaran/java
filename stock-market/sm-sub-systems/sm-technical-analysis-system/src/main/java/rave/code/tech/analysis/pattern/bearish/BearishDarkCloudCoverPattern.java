package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

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
        boolean gapUp = c2.getOpenPrice() > c1.getClosePrice();

        // Midpoint of first candle
        double midpoint = (c1.getOpenPrice() + c1.getClosePrice()) / 2.0;

        // Close below midpoint
        boolean deepPenetration = c2.getClosePrice() < midpoint;

        // Not a bearish engulfing
        boolean notEngulfing = c2.getClosePrice() > c1.getOpenPrice();

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
