package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishInvertedHammerDetector extends AbstractPatternDetector {

    public BullishInvertedHammerDetector() {
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
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishInvertedHammerDetector.isInvertedHammer(candles.get(0));
        } else {
            return false;
        }
    }
}
