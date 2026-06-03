package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishAbandonedBabyDetector {

    @Test
    public void testBullishAbandonedBabyDetector(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(84, 84.5, 85, 83);
        Candle c3 = new Candle(88, 98, 99, 87);

        boolean result =
                BullishAbandonedBabyDetector.isBullishAbandonedBaby(
                        c1, c2, c3);

        assertFalse(result);
    }

}