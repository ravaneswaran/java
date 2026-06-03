package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishKickerDetector {

    @Test
    public void testBullishKickerDetector(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(102, 112, 113, 101);

        boolean result = BullishKickerDetector.isBullishKicker(c1, c2);

        assertTrue(result);
    }
}
