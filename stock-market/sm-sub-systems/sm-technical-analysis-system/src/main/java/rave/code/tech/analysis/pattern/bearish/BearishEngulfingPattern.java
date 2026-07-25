package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BearishEngulfingPattern extends AbstractPattern {

    public BearishEngulfingPattern() {
        super(2);
    }

    public static boolean isEngulfing(Candle previous, Candle current) {

        // First candle bullish
        boolean firstBullish = previous.isBullish();

        // Second candle bearish
        boolean secondBearish = current.isBearish();

        // Current candle engulfs previous body
        boolean engulfing = current.getOpenPrice() > previous.getClosePrice() && current.getClosePrice() < previous.getOpenPrice();

        return firstBullish && secondBearish && engulfing;
    }

    @Override
    public String getName() {
        return "Bearish Engulfing";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishDarkCloudCoverPattern.isDarkCloudCover(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
