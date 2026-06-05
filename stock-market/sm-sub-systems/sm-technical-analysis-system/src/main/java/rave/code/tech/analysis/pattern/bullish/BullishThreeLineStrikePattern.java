package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishThreeLineStrikePattern extends AbstractPattern {

    public BullishThreeLineStrikePattern() {
        super(4);
    }

    public static boolean isThreeLineStrike(Candle c1, Candle c2, Candle c3, Candle c4) {

        // First three candles bullish
        boolean firstThreeBullish = c1.isBullish() && c2.isBullish() && c3.isBullish();

        // Higher closes
        boolean higherCloses = c2.getClose() > c1.getClose() && c3.getClose() > c2.getClose();

        // Fourth candle bearish
        boolean fourthBearish = c4.isBearish();

        // Opens above third close
        boolean opensAboveThird = c4.getOpen() > c3.getClose();

        // Closes below first open
        boolean closesBelowFirst = c4.getClose() < c1.getOpen();

        // Large engulfing body
        boolean engulfsAllBodies = c4.getOpen() > c3.getClose() && c4.getClose() < c1.getOpen();

        return firstThreeBullish
                && higherCloses
                && fourthBearish
                && opensAboveThird
                && closesBelowFirst
                && engulfsAllBodies;
    }

    @Override
    public String getName() {
        return "Bullish Three InsideUp";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishThreeLineStrikePattern.isThreeLineStrike(candles.get(0), candles.get(1), candles.get(2), candles.get(3));
        } else {
            return false;
        }
    }
}
