package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class RisingThreeMethodsDetector {

    public static boolean isRisingThreeMethods(Candle c1, Candle c2, Candle c3, Candle c4, Candle c5) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Middle candles bearish
        boolean middleBearish = c2.isBearish() && c3.isBearish() && c4.isBearish();

        // Middle candles remain within first candle range
        boolean insideRange = c2.getHigh() < c1.getHigh()
                && c2.getLow() > c1.getLow()
                && c3.getHigh() < c1.getHigh()
                && c3.getLow() > c1.getLow()
                && c4.getHigh() < c1.getHigh()
                && c4.getLow() > c1.getLow();

        // Final candle bullish
        boolean fifthBullish = c5.isBullish();

        // Breakout above first candle close
        boolean breakout = c5.getClose() > c1.getClose();

        // Strong final candle
        boolean strongFinal = c5.bodySize() >= (c1.bodySize() * 0.7);

        return firstBullish && middleBearish && insideRange && fifthBullish && breakout && strongFinal;
    }
}
