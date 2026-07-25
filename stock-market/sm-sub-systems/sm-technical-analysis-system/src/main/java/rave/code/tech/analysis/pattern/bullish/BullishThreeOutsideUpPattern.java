package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishThreeOutsideUpPattern extends AbstractPattern {

    public BullishThreeOutsideUpPattern() {
        super(3);
    }

    public static boolean isThreeOutsideUp(Candle c1, Candle c2, Candle c3) {

        // First candle bearish
        boolean firstBearish = c1.isBearish();

        // Second candle bullish
        boolean secondBullish = c2.isBullish();

        // Third candle bullish
        boolean thirdBullish = c3.isBullish();

        // Bullish engulfing
        boolean engulfing = c2.getOpenPrice() < c1.getClosePrice() && c2.getClosePrice() > c1.getOpenPrice();

        // Third candle confirmation
        boolean confirmation = c3.getClosePrice() > c2.getClosePrice();

        // Strong third candle
        boolean strongThird = c3.bodySize() >= (c2.bodySize() * 0.5);

        return firstBearish &&
                secondBullish &&
                thirdBullish &&
                engulfing &&
                confirmation &&
                strongThird;
    }

    @Override
    public String getName() {
        return "Bullish Three OutsideUp";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishThreeOutsideUpPattern.isThreeOutsideUp(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
