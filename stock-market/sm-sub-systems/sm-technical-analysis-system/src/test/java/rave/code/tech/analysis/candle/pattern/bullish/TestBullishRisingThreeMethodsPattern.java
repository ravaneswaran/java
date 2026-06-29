package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishRisingThreeMethodsPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishRisingThreeMethodsPattern {

    @Test
    public void testBullishRisingThreeMethodsPattern(){
        Candle c1 = new Candle(100, 110, 112, 99);
        Candle c2 = new Candle(109, 107, 110, 105);
        Candle c3 = new Candle(108, 106, 109, 104);
        Candle c4 = new Candle(107, 105, 108, 103);
        Candle c5 = new Candle(106, 115, 116, 105);

        boolean result =
                BullishRisingThreeMethodsPattern.isRisingThreeMethods(c1, c2, c3, c4, c5);

        assertTrue(result);
    }

}
