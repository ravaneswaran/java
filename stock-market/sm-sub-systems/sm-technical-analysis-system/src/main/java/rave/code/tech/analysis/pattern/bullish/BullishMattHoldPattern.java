package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishMattHoldPattern extends AbstractPattern {

    public BullishMattHoldPattern() {
        super(5);
    }

    public static boolean isMattHold(Candle c1, Candle c2, Candle c3, Candle c4, Candle c5) {

        // First candle strong bullish
        boolean firstBullish = c1.isBullish();

        // Gap-up on second candle
        boolean gapUp = c2.getLowPrice() > c1.getHighPrice();

        // Small pullback candles
        boolean smallBodies = c2.bodySize() < c1.bodySize() * 0.5 && c3.bodySize() < c1.bodySize() * 0.5 && c4.bodySize() < c1.bodySize() * 0.5;

        // Pullback remains above first candle open
        boolean controlledPullback = c2.getLowPrice() > c1.getOpenPrice() && c3.getLowPrice() > c1.getOpenPrice() && c4.getLowPrice() > c1.getOpenPrice();

        // Final strong bullish candle
        boolean fifthBullish = c5.isBullish();

        // Breakout above first candle close
        boolean breakout = c5.getClosePrice() > c1.getClosePrice();

        return firstBullish && gapUp && smallBodies && controlledPullback && fifthBullish && breakout;
    }

    @Override
    public String getName() {
        return "Bullish Matt Hold";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishMattHoldPattern.isMattHold(candles.get(0), candles.get(1), candles.get(2), candles.get(3), candles.get(4));
        } else {
            return false;
        }
    }
}
