package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.Candle;

public class BullishAbandonedBabyDetector {

    public static boolean isBullishAbandonedBaby(
            Candle c1,
            Candle c2,
            Candle c3) {

        // First candle bearish
        boolean firstBearish =
                c1.isBearish();

        // Second candle doji
        boolean doji =
                c2.isDoji();

        // Third candle bullish
        boolean thirdBullish =
                c3.isBullish();

        // Gap down between c1 and c2
        boolean gapDown =
                c2.getHigh() < c1.getLow();

        // Gap up between c2 and c3
        boolean gapUp =
                c3.getLow() > c2.getHigh();

        return firstBearish &&
                doji &&
                thirdBullish &&
                gapDown &&
                gapUp;
    }
}
