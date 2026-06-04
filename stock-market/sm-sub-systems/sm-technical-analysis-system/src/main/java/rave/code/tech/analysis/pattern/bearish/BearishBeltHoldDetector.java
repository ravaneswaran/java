package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishBeltHoldDetector extends AbstractPatternDetector {

    public BearishBeltHoldDetector(){
        super(1);
    }

    public static boolean isBeltHold(Candle candle) {

        if (!candle.isBearish()) {
            return false;
        }

        double range = candle.range();

        if (range == 0) {
            return false;
        }

        double upperShadow = candle.upperShadow();

        double body = candle.bodySize();

        // Very small upper shadow
        boolean noUpperShadow = upperShadow <= range * 0.05;

        // Large bearish body
        boolean longBody = body >= range * 0.60;

        return noUpperShadow && longBody;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishBeltHoldDetector.isBeltHold(candles.get(0));
        } else {
            return false;
        }
    }
}
