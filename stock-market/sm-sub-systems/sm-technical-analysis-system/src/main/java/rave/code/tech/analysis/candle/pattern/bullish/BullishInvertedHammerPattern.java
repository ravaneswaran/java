package rave.code.tech.analysis.candle.pattern.bullish;

import rave.code.tech.analysis.candle.pattern.AbstractPattern;
import rave.code.tech.analysis.candle.pattern.Candle;

import java.util.List;

public class BullishInvertedHammerPattern extends AbstractPattern {

    public BullishInvertedHammerPattern() {
        super(1);
    }

    public static boolean isInvertedHammer(
            Candle c) {

        double body =
                c.bodySize();

        double upperShadow =
                c.upperShadow();

        double lowerShadow =
                c.lowerShadow();

        // Long upper shadow
        boolean longUpperShadow =
                upperShadow >= (2 * body);

        // Small lower shadow
        boolean smallLowerShadow =
                lowerShadow <= (0.3 * body);

        // Small body relative to full range
        boolean smallBody =
                body <= ((c.getHigh() - c.getLow()) * 0.4);

        return longUpperShadow && smallLowerShadow && smallBody;
    }

    @Override
    public String getName() {
        return "Bullish Inverted Hammer";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishInvertedHammerPattern.isInvertedHammer(candles.get(0));
        } else {
            return false;
        }
    }
}
