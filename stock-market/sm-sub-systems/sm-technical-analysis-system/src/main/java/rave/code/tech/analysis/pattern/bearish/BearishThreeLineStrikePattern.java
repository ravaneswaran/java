package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishThreeLineStrikePattern extends AbstractPattern {

    public BearishThreeLineStrikePattern() {
        super(4);
    }

    public static boolean isThreeLineStrike(Candle c1, Candle c2, Candle c3, Candle c4) {
        // First three candles bearish
        boolean firstThreeBearish = c1.isBearish() && c2.isBearish() && c3.isBearish();

        // Lower closes
        boolean lowerCloses = c2.getClose() < c1.getClose() && c3.getClose() < c2.getClose();

        // Fourth candle bullish
        boolean fourthBullish = c4.isBullish();

        // Opens below third close
        boolean opensBelowThird = c4.getOpen() < c3.getClose();

        // Closes above first open
        boolean closesAboveFirst = c4.getClose() > c1.getOpen();

        // Engulfs previous 3 candles
        boolean engulfsAll = opensBelowThird && closesAboveFirst;

        return firstThreeBearish && lowerCloses && fourthBullish && engulfsAll;
    }

    @Override
    public String getName() {
        return "Bearish Three Line Strike";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishThreeLineStrikePattern.isThreeLineStrike(candles.get(0), candles.get(1), candles.get(2), candles.get(3));
        } else {
            return false;
        }
    }
}
