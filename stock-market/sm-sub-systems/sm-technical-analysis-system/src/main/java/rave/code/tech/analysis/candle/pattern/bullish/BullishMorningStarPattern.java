package rave.code.tech.analysis.candle.pattern.bullish;

import rave.code.tech.analysis.candle.pattern.AbstractPattern;
import rave.code.tech.analysis.candle.pattern.Candle;

import java.util.List;

public class BullishMorningStarPattern extends AbstractPattern {

    public BullishMorningStarPattern() {
        super(3);
    }

    public static boolean isMorningStar(Candle c1, Candle c2, Candle c3) {

        // First candle bearish
        boolean firstBearish =
                c1.getClose() < c1.getOpen();

        // Second candle small body
        boolean smallSecondBody =
                c2.bodySize() < (c1.bodySize() * 0.5);

        // Third candle bullish
        boolean thirdBullish =
                c3.getClose() > c3.getOpen();

        // Third candle closes above midpoint of first candle
        double midpoint =
                (c1.getOpen() + c1.getClose()) / 2;

        boolean closesAboveMidpoint =
                c3.getClose() > midpoint;

        return firstBearish &&
                smallSecondBody &&
                thirdBullish &&
                closesAboveMidpoint;
    }

    @Override
    public String getName() {
        return "Bullish Morning Star";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishMorningStarPattern.isMorningStar(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}