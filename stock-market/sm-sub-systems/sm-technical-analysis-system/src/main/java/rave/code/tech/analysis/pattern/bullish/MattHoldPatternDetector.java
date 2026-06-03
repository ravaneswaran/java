package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class MattHoldPatternDetector {

    public static boolean isMattHold(Candle c1, Candle c2, Candle c3, Candle c4, Candle c5) {

        // First candle strong bullish
        boolean firstBullish = c1.isBullish();

        // Gap-up on second candle
        boolean gapUp = c2.getLow() > c1.getHigh();

        // Small pullback candles
        boolean smallBodies = c2.bodySize() < c1.bodySize() * 0.5 && c3.bodySize() < c1.bodySize() * 0.5 && c4.bodySize() < c1.bodySize() * 0.5;

        // Pullback remains above first candle open
        boolean controlledPullback = c2.getLow() > c1.getOpen() && c3.getLow() > c1.getOpen() && c4.getLow() > c1.getOpen();

        // Final strong bullish candle
        boolean fifthBullish = c5.isBullish();

        // Breakout above first candle close
        boolean breakout = c5.getClose() > c1.getClose();

        return firstBullish && gapUp && smallBodies && controlledPullback && fifthBullish && breakout;
    }
}
