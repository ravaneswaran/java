package rave.code.tech.analysis.indicators;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRelativeStrengthIndex {

    private final RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex();

    @Test
    public void testCalculateRSI() {

        List<Candle> candles = new ArrayList<>();
        candles.add(new Candle(20, 10, 30, 5, 40, 3));
        candles.add(new Candle(30, 20, 40, 10, 50, 3));
        candles.add(new Candle(40, 30, 50, 15, 60, 3));
        candles.add(new Candle(50, 40, 60, 20, 70, 3));
        candles.add(new Candle(60, 50, 70, 25, 80, 3));
        candles.add(new Candle(70, 60, 70, 30, 90, 3));
        candles.add(new Candle(80, 70, 80, 35, 100, 3));
        candles.add(new Candle(90, 80, 90, 40, 110, 3));
        candles.add(new Candle(100, 90, 100, 45, 120, 3));
        candles.add(new Candle(110, 100, 110, 50, 130, 3));
        candles.add(new Candle(120, 110, 120, 55, 140, 3));
        candles.add(new Candle(130, 120, 130, 60, 150, 3));
        candles.add(new Candle(140, 130, 140, 65, 160, 3));
        candles.add(new Candle(150, 140, 150, 70, 170, 3));
        candles.add(new Candle(160, 150, 160, 75, 180, 3));

        double rsi = this.relativeStrengthIndex.calculate(candles, 14);

        assertTrue(rsi > 70);
    }
}
