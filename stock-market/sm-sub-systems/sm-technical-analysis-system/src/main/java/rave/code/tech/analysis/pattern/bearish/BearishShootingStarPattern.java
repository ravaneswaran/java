package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BearishShootingStarPattern extends AbstractPattern {

    public BearishShootingStarPattern() {
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
        boolean bodyNearLow = Math.min(candle.getOpenPrice(), candle.getClosePrice()) <= candle.getLowPrice() + (candle.getHighPrice() - candle.getLowPrice()) * 0.25;

        return longUpperShadow && smallLowerShadow && bodyNearLow;
    }

    @Override
    public String getName() {
        return "Bearish Shooting Star";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishShootingStarPattern.isShootingStar(candles.get(0));
        } else {
            return false;
        }
    }
}
