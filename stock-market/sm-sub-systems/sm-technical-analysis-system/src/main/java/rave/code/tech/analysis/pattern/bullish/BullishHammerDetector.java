package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishHammerDetector extends AbstractPatternDetector {

    public BullishHammerDetector() {
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
                body <= ((candle.getHigh() - candle.getLow()) * 0.4);

        return longLowerShadow &&
                smallUpperShadow &&
                smallBody;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishHammerDetector.isHammer(candles.get(0));
        } else {
            return false;
        }
    }
}
