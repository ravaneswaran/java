package rave.code.tech.analysis.pattern.bullish;

import rave.code.tech.analysis.pattern.AbstractPattern;
import rave.code.tech.analysis.Candle;

import java.util.List;

public class BullishPiercingLinePattern extends AbstractPattern {

    public BullishPiercingLinePattern() {
        super(2);
    }

    public static boolean isPiercingLine(Candle first, Candle second) {

        // First candle bearish
        boolean firstBearish =
                first.getClosePrice() < first.getOpenPrice();

        // Second candle bullish
        boolean secondBullish =
                second.getClosePrice() > second.getOpenPrice();

        // Gap down opening
        boolean gapDown =
                second.getOpenPrice() < first.getClosePrice();

        // Midpoint of first candle
        double midpoint =
                (first.getOpenPrice() + first.getClosePrice()) / 2;

        // Second candle closes above midpoint
        boolean closesAboveMidpoint =
                second.getClosePrice() > midpoint;

        // But below first candle open
        boolean belowFirstOpen =
                second.getClosePrice() < first.getOpenPrice();

        return firstBearish &&
                secondBullish &&
                gapDown &&
                closesAboveMidpoint &&
                belowFirstOpen;
    }

    @Override
    public String getName() {
        return "Bullish Piercing Line";
    }

    @Override
    public boolean matches(List<Candle> candles) {
        return false;
    }

    @Override
    public boolean detect(List<Candle> candles) {
        if (null != candles && candles.size() >= this.minimumCandles) {
            return BullishPiercingLinePattern.isPiercingLine(candles.get(0), candles.get(1));
        } else {
            return false;
        }
    }
}