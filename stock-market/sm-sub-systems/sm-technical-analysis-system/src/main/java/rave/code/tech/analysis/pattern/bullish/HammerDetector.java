package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class HammerDetector {

    public static boolean isHammer(Candle candle) {

        double body = candle.bodySize();

        double lowerShadow =
                candle.lowerShadow();

        double upperShadow =
                candle.upperShadow();

        // Long lower shadow
        boolean longLowerShadow =
                lowerShadow >= (2 * body);

        // Small upper shadow
        boolean smallUpperShadow =
                upperShadow <= (0.3 * body);

        // Small body compared to full candle range
        boolean smallBody =
                body <= ((candle.getHigh() - candle.getLow()) * 0.4);

        return longLowerShadow &&
                smallUpperShadow &&
                smallBody;
    }

}
