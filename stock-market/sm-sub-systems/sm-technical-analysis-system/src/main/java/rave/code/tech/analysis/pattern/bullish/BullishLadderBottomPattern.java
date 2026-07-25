package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishLadderBottomPattern extends AbstractPattern {

    public BullishLadderBottomPattern() {
        super(5);
    }

    public static boolean isLadderBottom(Candle c1, Candle c2, Candle c3, Candle c4, Candle c5) {

        // First three candles bearish
        boolean firstThreeBearish = c1.isBearish() && c2.isBearish() && c3.isBearish();

        // Lower closes
        boolean lowerCloses = c2.getClosePrice() < c1.getClosePrice() && c3.getClosePrice() < c2.getClosePrice();

        // Fourth candle bearish
        boolean fourthBearish = c4.isBearish();

        // Fourth candle has upper shadow
        boolean upperShadowExists = c4.upperShadow() > c4.bodySize() * 0.3;

        // Fifth candle bullish
        boolean fifthBullish = c5.isBullish();

        // Reversal confirmation
        boolean breakout = c5.getClosePrice() > c4.getOpenPrice();

        return firstThreeBearish
                && lowerCloses
                && fourthBearish
                && upperShadowExists
                && fifthBullish
                && breakout;
    }

    @Override
    public String getName() {
        return "Bullish Ladder Bottom";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishLadderBottomPattern.isLadderBottom(candles.get(0), candles.get(1), candles.get(2), candles.get(3), candles.get(4));
        } else {
            return false;
        }
    }
}
