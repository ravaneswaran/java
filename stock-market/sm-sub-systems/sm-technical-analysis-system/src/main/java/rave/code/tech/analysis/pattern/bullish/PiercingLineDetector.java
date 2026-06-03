package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class PiercingLineDetector {

    public static boolean isPiercingLine(Candle first, Candle second) {

        // First candle bearish
        boolean firstBearish =
                first.getClose() < first.getOpen();

        // Second candle bullish
        boolean secondBullish =
                second.getClose() > second.getOpen();

        // Gap down opening
        boolean gapDown =
                second.getOpen() < first.getClose();

        // Midpoint of first candle
        double midpoint =
                (first.getOpen() + first.getClose()) / 2;

        // Second candle closes above midpoint
        boolean closesAboveMidpoint =
                second.getClose() > midpoint;

        // But below first candle open
        boolean belowFirstOpen =
                second.getClose() < first.getOpen();

        return firstBearish &&
                secondBullish &&
                gapDown &&
                closesAboveMidpoint &&
                belowFirstOpen;
    }
}