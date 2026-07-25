package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishThreeInsideUpPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishThreeInsideUpPattern {

    @Test
    public void testTestThreeInsideUpPattern(){
        Candle c1 = new Candle(100, 90, 101, 89,0);
        Candle c2 = new Candle(92, 96, 97, 91,0);
        Candle c3 = new Candle(95, 104, 105, 94,0);

        boolean result = BullishThreeInsideUpPattern.isThreeInsideUp(c1, c2, c3);

        assertTrue(result);
    }
}
