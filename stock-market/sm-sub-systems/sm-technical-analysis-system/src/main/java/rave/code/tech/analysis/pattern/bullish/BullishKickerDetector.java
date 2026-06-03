package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class BullishKickerDetector {

    public static boolean isBullishKicker(Candle c1, Candle c2) {
        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Strong upward gap
        boolean gapUp = c2.getOpen() > c1.getOpen();

        // Strong bullish momentum
        boolean strongBullish = c2.bodySize() > (c1.bodySize() * 0.7);

        // Second candle closes above first open
        boolean strongClose = c2.getClose() > c1.getOpen();

        return firstBearish && secondBullish && gapUp && strongBullish && strongClose;
    }
}
