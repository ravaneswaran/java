package rave.code.tech.analysis.pattern.bearish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BearishEngulfingDetector extends AbstractPatternDetector {

    public BearishEngulfingDetector() {
        super(2);
    }

    public static boolean isEngulfing(Candle previous, Candle current) {

        // First candle bullish
        boolean firstBullish = previous.isBullish();

        // Second candle bearish
        boolean secondBearish = current.isBearish();

        // Current candle engulfs previous body
        boolean engulfing = current.getOpen() > previous.getClose() && current.getClose() < previous.getOpen();

        return firstBullish && secondBearish && engulfing;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BearishDarkCloudCoverDetector.isDarkCloudCover(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
