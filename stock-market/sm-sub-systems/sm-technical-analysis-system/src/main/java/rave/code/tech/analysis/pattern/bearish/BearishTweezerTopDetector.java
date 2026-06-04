package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishTweezerTopDetector extends AbstractPatternDetector {

    // Allow small price differences
    private static final double TOLERANCE = 0.20;

    public BearishTweezerTopDetector() {
        super(2);
    }

    public static boolean isTweezerTop(Candle c1, Candle c2) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();
        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Nearly equal highs
        boolean matchingHighs = Math.abs(c1.getHigh() - c2.getHigh()) <= TOLERANCE;

        return firstBullish && secondBearish && matchingHighs;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishTweezerTopDetector.isTweezerTop(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
