package rave.code.tech.analysis.candle.pattern.bullish;


import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishEngulfingPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishEngulfingPattern {

    @Test
    public void testBullishEngulfingPattern() {
        Candle candle1 = new Candle(100,95,102, 94);
        Candle candle2 = new Candle(93,105,106,92);

        boolean result = BullishEngulfingPattern.isEngulfing(candle1, candle2);

        assertTrue(result);
    }
}