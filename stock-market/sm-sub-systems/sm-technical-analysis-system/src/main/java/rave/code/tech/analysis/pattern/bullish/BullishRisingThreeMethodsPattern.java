package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishRisingThreeMethodsPattern extends AbstractPattern {

    public BullishRisingThreeMethodsPattern() {
        super(5);
    }

    public static boolean isRisingThreeMethods(Candle c1, Candle c2, Candle c3, Candle c4, Candle c5) {

        // First candle bullish
        boolean firstBullish = c1.isBullish();

        // Middle candles bearish
        boolean middleBearish = c2.isBearish() && c3.isBearish() && c4.isBearish();

        // Middle candles remain within first candle range
        boolean insideRange = c2.getHighPrice() < c1.getHighPrice()
                && c2.getLowPrice() > c1.getLowPrice()
                && c3.getHighPrice() < c1.getHighPrice()
                && c3.getLowPrice() > c1.getLowPrice()
                && c4.getHighPrice() < c1.getHighPrice()
                && c4.getLowPrice() > c1.getLowPrice();

        // Final candle bullish
        boolean fifthBullish = c5.isBullish();

        // Breakout above first candle close
        boolean breakout = c5.getClosePrice() > c1.getClosePrice();

        // Strong final candle
        boolean strongFinal = c5.bodySize() >= (c1.bodySize() * 0.7);

        return firstBullish && middleBearish && insideRange && fifthBullish && breakout && strongFinal;
    }

    @Override
    public String getName() {
        return "Bullish Rising Three Methods";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishRisingThreeMethodsPattern.isRisingThreeMethods(candles.get(0), candles.get(1), candles.get(2), candles.get(3), candles.get(4));
        } else {
            return false;
        }
    }
}
