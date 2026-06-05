package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishEngulfingPattern extends AbstractPattern {

    public BullishEngulfingPattern() {
        super(2);
    }

    public static boolean isEngulfing(Candle first, Candle second) {
        // First candle bearish
        boolean firstBearish = first.getClose() < first.getOpen();

        // Second candle bullish
        boolean secondBullish = second.getClose() > second.getOpen();

        // Engulfing condition
        boolean engulfing =
                second.getOpen() < first.getClose() &&
                        second.getClose() > first.getOpen();

        return firstBearish && secondBullish && engulfing;
    }

    @Override
    public String getName() {
        return "Bullish Engulfing";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return this.detect(candles);
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishEngulfingPattern.isEngulfing(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
