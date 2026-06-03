package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class BullishHaramiDetector {

    public static boolean isBullishHarami(
            Candle first,
            Candle second) {

        // First candle bearish
        boolean firstBearish =
                first.getClose() < first.getOpen();

        // Second candle bullish
        boolean secondBullish =
                second.getClose() > second.getOpen();

        // Second candle body inside first candle body
        boolean insideBody =
                second.getOpen() > first.getClose() &&
                        second.getClose() < first.getOpen();

        // Second candle smaller than first candle
        boolean smallerBody =
                second.bodySize() <
                        first.bodySize();

        return firstBearish &&
                secondBullish &&
                insideBody &&
                smallerBody;
    }
}
