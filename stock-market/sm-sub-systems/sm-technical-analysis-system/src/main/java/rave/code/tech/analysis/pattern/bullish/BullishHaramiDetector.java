package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPatternDetector;
import rave.code.tech.analysis.pattern.Candle;

import java.util.List;

public class BullishHaramiDetector extends AbstractPatternDetector {

    public BullishHaramiDetector() {
        super(2);
    }

    public static boolean isHarami(
            Candle first,
            Candle second) {

        // First candle bearish
        boolean firstBearish =
                first.getClose() < first.getOpen();

        // Second candle bullish
        boolean secondBullish =
                second.getClose() > second.getOpen();

        // Second candle body inside first candle body
        boolean insideBody =
                second.getOpen() > first.getClose() &&
                        second.getClose() < first.getOpen();

        // Second candle smaller than first candle
        boolean smallerBody =
                second.bodySize() <
                        first.bodySize();

        return firstBearish &&
                secondBullish &&
                insideBody &&
                smallerBody;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishHaramiDetector.isHarami(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}
