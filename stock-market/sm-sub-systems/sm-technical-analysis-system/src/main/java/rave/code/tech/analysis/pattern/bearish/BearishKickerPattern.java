package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BearishKickerPattern extends AbstractPattern {

    public BearishKickerPattern() {
        super(2);
    }

    public static boolean isKicker(Candle c1, Candle c2) {
        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Gap down open
        boolean gapDown = c2.getOpenPrice() < c1.getOpenPrice();

        // Strong bearish body
        boolean strongBody = c2.bodySize() >= c1.bodySize() * 0.8;

        return firstBullish
                && secondBearish
                && gapDown
                && strongBody;
    }

    @Override
    public String getName() {
        return "Bearish Kicker";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishKickerPattern.isKicker(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
