package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class DragonflyDojiDetector {

    public static boolean isDragonflyDoji(
            Candle candle) {

        double body =
                candle.bodySize();

        double upperShadow =
                candle.upperShadow();

        double lowerShadow =
                candle.lowerShadow();

        double range =
                candle.totalRange();

        // Open and close almost equal
        boolean dojiBody =
                body <= (range * 0.1);

        // Long lower shadow
        boolean longLowerShadow =
                lowerShadow >= (range * 0.6);

        // Very small upper shadow
        boolean tinyUpperShadow =
                upperShadow <= (range * 0.1);

        return dojiBody &&
                longLowerShadow &&
                tinyUpperShadow;
    }
}
