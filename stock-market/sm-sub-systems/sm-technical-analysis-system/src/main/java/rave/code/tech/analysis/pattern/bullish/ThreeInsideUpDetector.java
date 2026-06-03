package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class ThreeInsideUpDetector {

    public static boolean isThreeInsideUp(
            Candle c1,
            Candle c2,
            Candle c3) {

        // First candle bearish
        boolean firstBearish =
                c1.isBearish();

        // Second candle bullish
        boolean secondBullish =
                c2.isBullish();

        // Third candle bullish
        boolean thirdBullish =
                c3.isBullish();

        // Second candle inside first candle body
        boolean insideBody =
                c2.getOpen() > c1.getClose() &&
                        c2.getClose() < c1.getOpen();

        // Third candle closes above first candle open
        boolean breakout =
                c3.getClose() > c1.getOpen();

        // Third candle stronger than second
        boolean strongThird =
                c3.bodySize() >
                        c2.bodySize();

        return firstBearish &&
                secondBullish &&
                thirdBullish &&
                insideBody &&
                breakout &&
                strongThird;
    }
}
