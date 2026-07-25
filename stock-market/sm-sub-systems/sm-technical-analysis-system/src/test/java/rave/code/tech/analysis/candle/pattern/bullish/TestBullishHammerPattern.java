package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishHammerPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishHammerPattern {

    @Test
    public void testBullishHammerPattern(){
        Candle candle = new Candle(100, 102, 103, 90,0);
        boolean result = BullishHammerPattern.isHammer(candle);
        assertFalse(result);
    }

}
