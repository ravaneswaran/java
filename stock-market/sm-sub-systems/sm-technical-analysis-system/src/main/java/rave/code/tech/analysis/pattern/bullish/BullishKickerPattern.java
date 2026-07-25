package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishKickerPattern extends AbstractPattern {

    public BullishKickerPattern() {
        super(2);
    }

    public static boolean isKicker(Candle c1, Candle c2) {
        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Strong upward gap
        boolean gapUp = c2.getOpenPrice() > c1.getOpenPrice();

        // Strong bullish momentum
        boolean strongBullish = c2.bodySize() > (c1.bodySize() * 0.7);

        // Second candle closes above first open
        boolean strongClose = c2.getClosePrice() > c1.getOpenPrice();

        return firstBearish && secondBullish && gapUp && strongBullish && strongClose;
    }

    @Override
    public String getName() {
        return "Bullish Kicker";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishKickerPattern.isKicker(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
