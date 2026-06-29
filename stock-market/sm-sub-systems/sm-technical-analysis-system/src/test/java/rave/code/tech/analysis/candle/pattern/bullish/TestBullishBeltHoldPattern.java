package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishBeltHoldPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishBeltHoldPattern {

    @Test
    public void testBullishBeltHoldPattern(){
        Candle candle = new Candle(100, 112, 114, 100);

        boolean result = BullishBeltHoldPattern.isBeltHold(candle);

        assertTrue(result);
    }

}
