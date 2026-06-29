package rave.code.tech.analysis.candle.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bearish.BearishBeltHoldPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishBeltHoldPattern {

    @Test
    public void testBearishBeltHoldPattern(){
        Candle candle = new Candle(120, 120, 105, 108);

        boolean result = BearishBeltHoldPattern.isBeltHold(candle);

        assertFalse(result);
    }
}
