package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BearishDojiStarPattern extends AbstractPattern {

    public BearishDojiStarPattern() {
        super(3);
    }

    public static boolean isDojiStar(Candle c1, Candle c2, Candle c3) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Middle candle is Doji
        boolean doji = c2.bodySize() <= c2.range() * 0.10;

        // Third candle bearish
        boolean thirdBearish = c3.isBearish();

        // Third closes below midpoint
        double midpoint = (c1.getOpenPrice() + c1.getClosePrice()) / 2.0;

        boolean deepClose = c3.getClosePrice() < midpoint;

        return firstBullish
                && doji
                && thirdBearish
                && deepClose;
    }

    @Override
    public String getName() {
        return "Bearish Doji Star";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishDojiStarPattern.isDojiStar(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
