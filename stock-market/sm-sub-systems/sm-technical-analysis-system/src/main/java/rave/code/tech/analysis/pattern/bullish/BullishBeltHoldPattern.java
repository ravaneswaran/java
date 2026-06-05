package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishBeltHoldPattern extends AbstractPattern {

    public BullishBeltHoldPattern() {
        super(1);
    }

    public static boolean isBeltHold(Candle candle) {
        // Must be bullish
        boolean bullish = candle.isBullish();

        double body = candle.bodySize();
        double range = candle.range();
        double lowerShadow = candle.lowerShadow();

        // Very small lower shadow
        boolean noLowerShadow = lowerShadow <= range * 0.05;

        // Large bullish body
        boolean longBody = body >= range * 0.60;

        return bullish && noLowerShadow && longBody;
    }

    @Override
    public String getName() {
        return "Bullish Belt Hold";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishBeltHoldPattern.isBeltHold(candles.get(0));
        } else {
            return false;
        }
    }
}
