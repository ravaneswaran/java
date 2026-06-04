package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishDojiStarDetector extends AbstractPatternDetector {

    public BearishDojiStarDetector() {
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
        double midpoint = (c1.getOpen() + c1.getClose()) / 2.0;

        boolean deepClose = c3.getClose() < midpoint;

        return firstBullish
                && doji
                && thirdBearish
                && deepClose;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishDojiStarDetector.isDojiStar(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
