package rave.code.tech.analysis.indicators.movingaverage;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSimpleMovingAverage {

    @Test
    public void testGetValueForLast_05_LTP() {
        List<Candle> candles = new ArrayList<>();
        candles.add(new Candle(11.0, 10.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 20.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 30.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 40.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 50.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 60.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 70.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 80.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 90.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 100.0, 12.0, 9.0, 4, 3));

        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(candles);
        double result = simpleMovingAverage.getValue();

        assertTrue(0 != result);
        assertTrue(80 == result);
    }

    @Test
    public void testGetValueForLast_10_LTP() {
        List<Candle> candles = new ArrayList<>();
        candles.add(new Candle(11.0, 10.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 20.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 30.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 40.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 50.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 60.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 70.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 80.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 90.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 100.0, 12.0, 9.0, 4, 3));

        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(candles, 10);
        double result = simpleMovingAverage.getValue();

        assertTrue(0 != result);
        assertTrue(55 == result);
    }

    @Test
    public void testGetValueForLast_20_LTP() {
        List<Candle> candles = new ArrayList<>();
        candles.add(new Candle(11.0, 10.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 20.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 30.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 40.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 50.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 60.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 70.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 80.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 90.0, 12.0, 9.0, 4, 3));
        candles.add(new Candle(11.0, 100.0, 12.0, 9.0, 4, 3));

        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(candles, 20);
        double result = simpleMovingAverage.getValue();

        assertTrue(0 != result);
        assertTrue(55 == result);
    }
}
