package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishConcealingBabySwallowPattern extends AbstractPattern {

    private static final double SHADOW_TOLERANCE = 0.05;

    public BullishConcealingBabySwallowPattern() {
        super(4);
    }

    private static boolean isMarubozu(Candle c) {
        double range = c.range();
        return c.isBearish() && c.upperShadow() <= range * SHADOW_TOLERANCE && c.lowerShadow() <= range * SHADOW_TOLERANCE;
    }

    public static boolean isConcealingBabySwallow(Candle c1, Candle c2, Candle c3, Candle c4) {

        // First two bearish marubozu candles
        boolean firstMarubozu = isMarubozu(c1);
        boolean secondMarubozu = isMarubozu(c2);

        // Gap down between c1 and c2
        boolean gapDownSecond = c2.getOpenPrice() < c1.getClosePrice();

        // Third candle bearish with upper shadow
        boolean thirdBearish = c3.isBearish();
        boolean thirdHasUpperShadow = c3.upperShadow() > 0;

        // Gap down before third candle
        boolean gapDownThird = c3.getHighPrice() < c2.getLowPrice();

        // Fourth candle bearish
        boolean fourthBearish = c4.isBearish();

        // Fourth candle opens above third body
        boolean opensAboveThirdBody = c4.getOpenPrice() > Math.max(c3.getOpenPrice(), c3.getClosePrice());

        // Fourth candle engulfs third candle range
        boolean engulfsThirdRange = c4.getHighPrice() > c3.getHighPrice() && c4.getLowPrice() < c3.getLowPrice();

        return firstMarubozu && secondMarubozu && gapDownSecond && thirdBearish && thirdHasUpperShadow && gapDownThird && fourthBearish && opensAboveThirdBody && engulfsThirdRange;
    }

    @Override
    public String getName() {
        return "Bullish Concealing Baby Swallow";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishConcealingBabySwallowPattern.isConcealingBabySwallow(candles.get(0), candles.get(1), candles.get(2), candles.get(3));
        } else {
            return false;
        }
    }
}
