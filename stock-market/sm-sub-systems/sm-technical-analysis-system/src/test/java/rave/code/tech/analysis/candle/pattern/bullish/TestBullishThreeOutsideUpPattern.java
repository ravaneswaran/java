package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishThreeOutsideUpPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishThreeOutsideUpPattern {

    @Test
    public void testBullishThreeOutsideUpPattern(){
        Candle c1 = new Candle(100, 90, 101, 89,0);
        Candle c2 = new Candle(88, 104, 105, 87,0);
        Candle c3 = new Candle(103, 110, 111, 102,0);

        boolean result =
                BullishThreeOutsideUpPattern.isThreeOutsideUp(
                        c1, c2, c3);

        assertFalse(result);
    }

}
