package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishAbandonedBabyPattern extends AbstractPattern {

    public BearishAbandonedBabyPattern(){
        super(3);
    }

    public static boolean isAbandonedBaby(Candle c1, Candle c2, Candle c3) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Middle candle doji
        boolean doji = c2.bodySize() <= c2.range() * 0.10;

        // Gap up from first candle
        boolean gapUp = c2.getLow() > c1.getHigh();

        // Third candle bearish
        boolean thirdBearish = c3.isBearish();

        // Gap down below doji
        boolean gapDown = c3.getHigh() < c2.getLow();

        // Close below midpoint of candle 1
        double midpoint = (c1.getOpen() + c1.getClose()) / 2.0;

        boolean deepClose = c3.getClose() < midpoint;

        return firstBullish
                && doji
                && gapUp
                && thirdBearish
                && gapDown
                && deepClose;
    }

    @Override
    public String getName() {
        return "Bearish Abandoned Baby";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishAbandonedBabyPattern.isAbandonedBaby(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}