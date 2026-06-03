package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class ThreeLineStrikeDetector {

    public static boolean isBullishThreeLineStrike(Candle c1, Candle c2, Candle c3, Candle c4) {

        // First three candles bullish
        boolean firstThreeBullish = c1.isBullish() && c2.isBullish() && c3.isBullish();

        // Higher closes
        boolean higherCloses = c2.getClose() > c1.getClose() && c3.getClose() > c2.getClose();

        // Fourth candle bearish
        boolean fourthBearish = c4.isBearish();

        // Opens above third close
        boolean opensAboveThird = c4.getOpen() > c3.getClose();

        // Closes below first open
        boolean closesBelowFirst = c4.getClose() < c1.getOpen();

        // Large engulfing body
        boolean engulfsAllBodies = c4.getOpen() > c3.getClose() && c4.getClose() < c1.getOpen();

        return firstThreeBullish
                && higherCloses
                && fourthBearish
                && opensAboveThird
                && closesBelowFirst
                && engulfsAllBodies;
    }

}
