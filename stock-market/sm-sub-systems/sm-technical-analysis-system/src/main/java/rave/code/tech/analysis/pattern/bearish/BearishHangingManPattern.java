package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishHangingManPattern extends AbstractPattern {

    public BearishHangingManPattern() {
        super(1);
    }

    public static boolean isHangingMan(Candle candle) {
        double body = candle.bodySize();

        if (body == 0) {
            return false;
        }

        double upperShadow = candle.upperShadow();
        double lowerShadow = candle.lowerShadow();

        // Long lower shadow
        boolean longLowerShadow = lowerShadow >= body * 2;

        // Small upper shadow
        boolean smallUpperShadow = upperShadow <= body * 0.3;

        return longLowerShadow && smallUpperShadow;
    }

    @Override
    public String getName() {
        return "Bearish Hanging Man";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishHangingManPattern.isHangingMan(candles.get(0));
        } else {
            return false;
        }
    }
}

