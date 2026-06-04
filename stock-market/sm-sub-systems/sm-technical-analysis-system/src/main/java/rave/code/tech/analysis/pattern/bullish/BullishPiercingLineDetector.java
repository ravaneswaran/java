package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishPiercingLineDetector extends AbstractPatternDetector {

    public BullishPiercingLineDetector() {
        super(2);
    }

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

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishPiercingLineDetector.isPiercingLine(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}