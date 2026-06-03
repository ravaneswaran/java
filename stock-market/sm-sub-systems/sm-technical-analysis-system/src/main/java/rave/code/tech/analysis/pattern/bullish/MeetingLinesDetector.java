package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class MeetingLinesDetector {

    private static final double TOLERANCE_PERCENT = 0.002; // 0.2%

    public static boolean isBullishMeetingLines(Candle c1, Candle c2) {

        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Optional gap down
        boolean gapDown = c2.getOpen() < c1.getClose();

        // Closes approximately equal
        double tolerance = c1.getClose() * TOLERANCE_PERCENT;

        boolean sameClose = Math.abs(c1.getClose() - c2.getClose()) <= tolerance;

        return firstBearish
                && secondBullish
                && sameClose
                && gapDown;
    }
}
