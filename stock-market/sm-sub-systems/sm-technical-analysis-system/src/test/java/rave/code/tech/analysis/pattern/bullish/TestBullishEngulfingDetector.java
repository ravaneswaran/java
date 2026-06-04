package rave.code.tech.analysis.pattern.bullish;


import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishEngulfingDetector {

    @Test
    public void testBullishEngulfing() {
        Candle candle1 = new Candle(100,95,102, 94);
        Candle candle2 = new Candle(93,105,106,92);

        boolean result = BullishEngulfingDetector.isEngulfing(candle1, candle2);

        assertTrue(result);
    }
}