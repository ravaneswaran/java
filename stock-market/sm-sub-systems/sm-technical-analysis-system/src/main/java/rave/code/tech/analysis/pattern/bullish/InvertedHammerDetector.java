package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class InvertedHammerDetector {

    public static boolean isInvertedHammer(
            Candle c) {

        double body =
                c.bodySize();

        double upperShadow =
                c.upperShadow();

        double lowerShadow =
                c.lowerShadow();

        // Long upper shadow
        boolean longUpperShadow =
                upperShadow >= (2 * body);

        // Small lower shadow
        boolean smallLowerShadow =
                lowerShadow <= (0.3 * body);

        // Small body relative to full range
        boolean smallBody =
                body <= ((c.getHigh() - c.getLow()) * 0.4);

        return longUpperShadow && smallLowerShadow && smallBody;
    }

}
