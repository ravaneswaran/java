package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishEngulfingPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishEngulfingPattern {

    @Test
    public void testBullishEngulfingPattern() {
        Candle candle1 = new Candle(100, 95, 102, 94, 0, 0);
        Candle candle2 = new Candle(93, 105, 106, 92, 0, 0);

        boolean result = BullishEngulfingPattern.isEngulfing(candle1, candle2);

        assertTrue(result);
    }
}