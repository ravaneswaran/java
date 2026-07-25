package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishAbandonedBabyPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishAbandonedBabyPattern {

    @Test
    public void testBullishAbandonedBabyPattern() {
        Candle c1 = new Candle(100, 90, 101, 89, 0, 0);
        Candle c2 = new Candle(84, 84.5, 85, 83, 0, 0);
        Candle c3 = new Candle(88, 98, 99, 87, 0, 0);

        boolean result =
                BullishAbandonedBabyPattern.isAbandonedBaby(
                        c1, c2, c3);

        assertFalse(result);
    }
}