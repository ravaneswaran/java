package rave.code.tech.analysis.candle.pattern.bullish;

import rave.code.tech.analysis.candle.pattern.AbstractPattern;
import rave.code.tech.analysis.candle.pattern.Candle;

import java.util.List;

public class BullishAbandonedBabyPattern extends AbstractPattern {

    public BullishAbandonedBabyPattern() {
        super(3);
    }

    public static boolean isAbandonedBaby(
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

    @Override
    public String getName() {
        return "Bullish Abandoned Baby";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishAbandonedBabyPattern.isAbandonedBaby(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
