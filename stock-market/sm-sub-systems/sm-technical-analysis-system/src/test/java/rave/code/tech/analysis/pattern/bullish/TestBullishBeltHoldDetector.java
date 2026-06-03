package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishBeltHoldDetector {

    @Test
    public void testBullishBeltHoldDetector(){
        Candle candle = new Candle(100, 112, 114, 100);

        boolean result = BullishBeltHoldDetector.isBullishBeltHold(candle);

        assertTrue(result);
    }

}
