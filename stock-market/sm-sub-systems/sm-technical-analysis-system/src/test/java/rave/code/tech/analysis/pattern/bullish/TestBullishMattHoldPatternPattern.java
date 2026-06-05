package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishMattHoldPatternPattern {

    @Test
    public void testMattHoldPatternPattern() {
        Candle c1 = new Candle(100, 115, 116, 99);
        Candle c2 = new Candle(118, 116, 119, 115);
        Candle c3 = new Candle(116, 114, 117, 113);
        Candle c4 = new Candle(114, 113, 115, 112);
        Candle c5 = new Candle(114, 122, 123, 113);

        boolean result =
                BullishMattHoldPattern.isMattHold(c1, c2, c3, c4, c5);

        assertFalse(result);
    }

}
