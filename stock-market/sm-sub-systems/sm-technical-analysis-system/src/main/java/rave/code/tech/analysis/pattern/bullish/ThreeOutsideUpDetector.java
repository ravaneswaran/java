package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class ThreeOutsideUpDetector {

    public static boolean isThreeOutsideUp(Candle c1, Candle c2, Candle c3) {

        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Third candle bullish
        boolean thirdBullish = c3.isBullish();

        // Bullish engulfing
        boolean engulfing = c2.getOpen() < c1.getClose() && c2.getClose() > c1.getOpen();

        // Third candle confirmation
        boolean confirmation = c3.getClose() > c2.getClose();

        // Strong third candle
        boolean strongThird = c3.bodySize() >= (c2.bodySize() * 0.5);

        return firstBearish &&
                secondBullish &&
                thirdBullish &&
                engulfing &&
                confirmation &&
                strongThird;
    }
}
