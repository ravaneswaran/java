package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishLadderBottomDetector extends AbstractPatternDetector {

    public BullishLadderBottomDetector() {
        super(5);
    }

    static boolean isLadderBottom(Candle c1, Candle c2, Candle c3, Candle c4, Candle c5) {

        // First three candles bearish
        boolean firstThreeBearish = c1.isBearish() && c2.isBearish() && c3.isBearish();

        // Lower closes
        boolean lowerCloses = c2.getClose() < c1.getClose() && c3.getClose() < c2.getClose();

        // Fourth candle bearish
        boolean fourthBearish = c4.isBearish();

        // Fourth candle has upper shadow
        boolean upperShadowExists = c4.upperShadow() > c4.bodySize() * 0.3;

        // Fifth candle bullish
        boolean fifthBullish = c5.isBullish();

        // Reversal confirmation
        boolean breakout = c5.getClose() > c4.getOpen();

        return firstThreeBearish
                && lowerCloses
                && fourthBearish
                && upperShadowExists
                && fifthBullish
                && breakout;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishLadderBottomDetector.isLadderBottom(candles.get(0), candles.get(1), candles.get(2), candles.get(3), candles.get(4));
        } else {
            return false;
        }
    }
}
