package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class ThreeWhiteSoldiersDetector {

    public static boolean isThreeWhiteSoldiers(
            Candle c1,
            Candle c2,
            Candle c3) {

        // All candles bullish
        boolean bullishCandles =
                c1.isBullish() &&
                        c2.isBullish() &&
                        c3.isBullish();

        // Higher closes
        boolean higherCloses =
                c1.getClose() < c2.getClose() &&
                        c2.getClose() < c3.getClose();

        // Opens inside previous body
        boolean properOpens =
                c2.getOpen() > c1.getOpen() &&
                        c2.getOpen() < c1.getClose() &&

                        c3.getOpen() > c2.getOpen() &&
                        c3.getOpen() < c2.getClose();

        // Strong candle bodies
        boolean strongBodies =
                c1.bodySize() > 0 &&
                        c2.bodySize() > 0 &&
                        c3.bodySize() > 0;

        return bullishCandles &&
                higherCloses &&
                properOpens &&
                strongBodies;
    }
}
