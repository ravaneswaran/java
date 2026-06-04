package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishMeetingLinesDetector extends AbstractPatternDetector {

    private static final double TOLERANCE_PERCENT = 0.002; // 0.2%

    public BullishMeetingLinesDetector() {
        super(2);
    }

    public static boolean isMeetingLines(Candle c1, Candle c2) {

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

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishMeetingLinesDetector.isMeetingLines(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
