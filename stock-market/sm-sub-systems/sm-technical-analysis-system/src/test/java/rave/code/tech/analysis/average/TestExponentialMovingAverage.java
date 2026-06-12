package rave.code.tech.analysis.average;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.units.LastTradedPrice;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExponentialMovingAverage {

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

        ExponentialMovingAverage exponentialMovingAverage = new ExponentialMovingAverage(lastTradedPrices, 5);
        List<Double> result = exponentialMovingAverage.getValue();

        assertTrue(null != result);
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

        ExponentialMovingAverage exponentialMovingAverage = new ExponentialMovingAverage(lastTradedPrices, 10);
        List<Double> result = exponentialMovingAverage.getValue();

        assertTrue(null != result);
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

        ExponentialMovingAverage exponentialMovingAverage = new ExponentialMovingAverage(lastTradedPrices, 10);
        List<Double> result = exponentialMovingAverage.getValue();

        assertTrue(null != result);
    }

}
