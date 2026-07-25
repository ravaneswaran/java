package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BearishThreeInsideDownPattern extends AbstractPattern {

    public BearishThreeInsideDownPattern() {
        super(3);
    }

    public static boolean isThreeInsideDown(Candle c1, Candle c2, Candle c3) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Third candle bearish
        boolean thirdBearish = c3.isBearish();

        // Harami condition
        boolean insideBody = c2.getOpenPrice() < c1.getClosePrice()
                        && c2.getOpenPrice() > c1.getOpenPrice()
                        && c2.getClosePrice() < c1.getClosePrice()
                        && c2.getClosePrice() > c1.getOpenPrice();

        // Confirmation candle
        boolean confirmation = c3.getClosePrice() < c2.getClosePrice();

        // Small second candle
        boolean smallSecondBody = c2.bodySize() < c1.bodySize() * 0.5;

        return firstBullish
                && secondBearish
                && thirdBearish
                && insideBody
                && confirmation
                && smallSecondBody;
    }

    @Override
    public String getName() {
        return "Bearish Three Inside Down";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishThreeInsideDownPattern.isThreeInsideDown(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
