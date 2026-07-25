package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishSeparatingLinesPattern extends AbstractPattern {

    // Allow small price differences
    private static final double TOLERANCE = 0.20;

    public BullishSeparatingLinesPattern() {
        super(2);
    }

    public static boolean isSeparatingLines(Candle c1, Candle c2) {
        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Nearly identical opens
        boolean sameOpen = Math.abs(c1.getOpenPrice() - c2.getOpenPrice()) <= TOLERANCE;

        // Strong bullish continuation
        boolean breakout = c2.getClosePrice() > c1.getHighPrice();

        return firstBearish && secondBullish && sameOpen && breakout;
    }

    @Override
    public String getName() {
        return "Bullish Separating Lines";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishSeparatingLinesPattern.isSeparatingLines(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
