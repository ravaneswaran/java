package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishHammerPattern extends AbstractPattern {

    public BullishHammerPattern() {
        super(1);
    }

    public static boolean isHammer(Candle candle) {

        double body = candle.bodySize();

        double lowerShadow =
                candle.lowerShadow();

        double upperShadow =
                candle.upperShadow();

        // Long lower shadow
        boolean longLowerShadow =
                lowerShadow >= (2 * body);

        // Small upper shadow
        boolean smallUpperShadow =
                upperShadow <= (0.3 * body);

        // Small body compared to full candle range
        boolean smallBody =
                body <= ((candle.getHighPrice() - candle.getLowPrice()) * 0.4);

        return longLowerShadow &&
                smallUpperShadow &&
                smallBody;
    }

    @Override
    public String getName() {
        return "Bullish Hammer";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishHammerPattern.isHammer(candles.get(0));
        } else {
            return false;
        }
    }
}
