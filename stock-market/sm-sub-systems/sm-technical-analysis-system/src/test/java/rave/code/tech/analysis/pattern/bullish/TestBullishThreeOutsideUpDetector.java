package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishThreeOutsideUpDetector {

    @Test
    public void test(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(88, 104, 105, 87);
        Candle c3 = new Candle(103, 110, 111, 102);

        boolean result =
                BullishThreeOutsideUpDetector.isThreeOutsideUp(
                        c1, c2, c3);

        assertFalse(result);
    }

}
