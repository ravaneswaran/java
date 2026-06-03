package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class BullishEngulfingDetector {

    public static boolean isBullishEngulfing(Candle first, Candle second) {
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
}
