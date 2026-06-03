package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class BullishBeltHoldDetector {

    public static boolean isBullishBeltHold(Candle candle) {
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
}
