package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BearishThreeBlackCrowsPattern extends AbstractPattern {

    public BearishThreeBlackCrowsPattern() {
        super(3);
    }

    public static boolean isThreeBlackCrows(Candle c1, Candle c2, Candle c3) {
        // All candles must be bearish
        boolean allBearish = c1.isBearish() && c2.isBearish() && c3.isBearish();

        // Consecutively lower closes
        boolean lowerCloses = c2.getClosePrice() < c1.getClosePrice() && c3.getClosePrice() < c2.getClosePrice();

        // Opens within previous body
        boolean properOpens = c2.getOpenPrice() < c1.getOpenPrice() && c2.getOpenPrice() > c1.getClosePrice() && c3.getOpenPrice() < c2.getOpenPrice() && c3.getOpenPrice() > c2.getClosePrice();

        return allBearish && lowerCloses && properOpens;
    }

    @Override
    public String getName() {
        return "Bearish Three Black Crows";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishThreeBlackCrowsPattern.isThreeBlackCrows(candles.get(0), candles.get(1), candles.get(2));
        } else {
            return false;
        }
    }
}
