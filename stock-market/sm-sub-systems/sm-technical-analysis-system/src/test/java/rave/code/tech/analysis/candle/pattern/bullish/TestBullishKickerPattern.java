package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishKickerPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishKickerPattern {

    @Test
    public void testBullishKickerPattern(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(102, 112, 113, 101);

        boolean result = BullishKickerPattern.isKicker(c1, c2);

        assertTrue(result);
    }
}
