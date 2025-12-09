package rave.code.tech.analysis.average;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSimpleMovingAverage {

    @Test
    public void testGetValueForLast_05_LTP() {
        List<LastTradedPrice> lastTradedPrices = new ArrayList<>();
        lastTradedPrices.add(new LastTradedPrice(10.0));
        lastTradedPrices.add(new LastTradedPrice(20.0));
        lastTradedPrices.add(new LastTradedPrice(30.0));
        lastTradedPrices.add(new LastTradedPrice(40.0));
        lastTradedPrices.add(new LastTradedPrice(50.0));
        lastTradedPrices.add(new LastTradedPrice(60.0));
        lastTradedPrices.add(new LastTradedPrice(70.0));
        lastTradedPrices.add(new LastTradedPrice(80.0));
        lastTradedPrices.add(new LastTradedPrice(90.0));
        lastTradedPrices.add(new LastTradedPrice(100.0));

        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(lastTradedPrices);
        double result = simpleMovingAverage.getValue();

        assertTrue(0 != result);
        assertTrue(80 == result);
    }

    @Test
    public void testGetValueForLast_10_LTP() {
        List<LastTradedPrice> lastTradedPrices = new ArrayList<>();
        lastTradedPrices.add(new LastTradedPrice(10.0));
        lastTradedPrices.add(new LastTradedPrice(20.0));
        lastTradedPrices.add(new LastTradedPrice(30.0));
        lastTradedPrices.add(new LastTradedPrice(40.0));
        lastTradedPrices.add(new LastTradedPrice(50.0));
        lastTradedPrices.add(new LastTradedPrice(60.0));
        lastTradedPrices.add(new LastTradedPrice(70.0));
        lastTradedPrices.add(new LastTradedPrice(80.0));
        lastTradedPrices.add(new LastTradedPrice(90.0));
        lastTradedPrices.add(new LastTradedPrice(100.0));

        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(lastTradedPrices, 10);
        double result = simpleMovingAverage.getValue();

        assertTrue(0 != result);
        assertTrue(55 == result);
    }

    @Test
    public void testGetValueForLast_20_LTP() {
        List<LastTradedPrice> lastTradedPrices = new ArrayList<>();
        lastTradedPrices.add(new LastTradedPrice(10.0));
        lastTradedPrices.add(new LastTradedPrice(20.0));
        lastTradedPrices.add(new LastTradedPrice(30.0));
        lastTradedPrices.add(new LastTradedPrice(40.0));
        lastTradedPrices.add(new LastTradedPrice(50.0));
        lastTradedPrices.add(new LastTradedPrice(60.0));
        lastTradedPrices.add(new LastTradedPrice(70.0));
        lastTradedPrices.add(new LastTradedPrice(80.0));
        lastTradedPrices.add(new LastTradedPrice(90.0));
        lastTradedPrices.add(new LastTradedPrice(100.0));

        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(lastTradedPrices, 20);
        double result = simpleMovingAverage.getValue();

        assertTrue(0 != result);
        assertTrue(55 == result);
    }
}
