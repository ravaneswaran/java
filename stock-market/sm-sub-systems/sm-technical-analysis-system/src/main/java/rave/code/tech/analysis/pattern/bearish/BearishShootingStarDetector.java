package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishShootingStarDetector extends AbstractPatternDetector {

    public BearishShootingStarDetector() {
        super(1);
    }

    public static boolean isShootingStar(Candle candle) {
        double body = candle.bodySize();

        if (body == 0) {
            return false;
        }

        double upperShadow = candle.upperShadow();
        double lowerShadow = candle.lowerShadow();

        // Long upper shadow
        boolean longUpperShadow = upperShadow >= body * 2.0;
        // Very small lower shadow
        boolean smallLowerShadow = lowerShadow <= body * 0.3;
        // Body near session low
        boolean bodyNearLow = Math.min(candle.getOpen(), candle.getClose()) <= candle.getLow() + (candle.getHigh() - candle.getLow()) * 0.25;

        return longUpperShadow && smallLowerShadow && bodyNearLow;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishShootingStarDetector.isShootingStar(candles.get(0));
        } else {
            return false;
        }
    }
}
