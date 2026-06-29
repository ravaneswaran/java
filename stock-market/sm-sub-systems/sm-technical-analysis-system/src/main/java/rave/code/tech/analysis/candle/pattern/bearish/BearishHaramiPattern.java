package rave.code.tech.analysis.candle.pattern.bearish;

import rave.code.tech.analysis.candle.pattern.AbstractPattern;
import rave.code.tech.analysis.candle.pattern.Candle;

import java.util.List;

public class BearishHaramiPattern extends AbstractPattern {

    public BearishHaramiPattern() {
        super(2);
    }

    public static boolean isHarami(Candle c1, Candle c2) {
        // First candle bullish
        boolean firstBullish = c1.isBullish();
        // Second candle bearish
        boolean secondBearish = c2.isBearish();

        // Entire second body
        // inside first body
        boolean insideBody = c2.getOpen() < c1.getClose() && c2.getOpen() > c1.getOpen()
                        && c2.getClose() < c1.getClose()
                        && c2.getClose() > c1.getOpen();

        // Small second candle
        boolean smallBody = c2.bodySize() < c1.bodySize() * 0.5;

        return firstBullish && secondBearish && insideBody && smallBody;
    }

    @Override
    public String getName() {
        return "Bearish Harami";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishHaramiPattern.isHarami(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
