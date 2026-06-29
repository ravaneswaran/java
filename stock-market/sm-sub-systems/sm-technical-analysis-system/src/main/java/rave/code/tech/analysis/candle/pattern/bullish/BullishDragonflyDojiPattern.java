package rave.code.tech.analysis.candle.pattern.bullish;

import rave.code.tech.analysis.candle.pattern.AbstractPattern;
import rave.code.tech.analysis.candle.pattern.Candle;

import java.util.List;

public class BullishDragonflyDojiPattern extends AbstractPattern {

    public BullishDragonflyDojiPattern() {
        super(1);
    }

    public static boolean isDragonflyDoji(
            Candle candle) {

        double body =
                candle.bodySize();

        double upperShadow =
                candle.upperShadow();

        double lowerShadow =
                candle.lowerShadow();

        double range =
                candle.totalRange();

        // Open and close almost equal
        boolean dojiBody =
                body <= (range * 0.1);

        // Long lower shadow
        boolean longLowerShadow =
                lowerShadow >= (range * 0.6);

        // Very small upper shadow
        boolean tinyUpperShadow =
                upperShadow <= (range * 0.1);

        return dojiBody &&
                longLowerShadow &&
                tinyUpperShadow;
    }

    @Override
    public String getName() {
        return "Bullish Dragonfly Doji";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishDragonflyDojiPattern.isDragonflyDoji(candles.get(0));
        } else {
            return false;
        }
    }
}
