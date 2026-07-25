package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishAbandonedBabyPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishAbandonedBabyPattern {

    @Test
    public void testBearishAbandonedBabyPattern() {
        Candle c1 = new Candle(100, 115, 99, 112, 0, 0);
        Candle c2 = new Candle(118, 119, 117, 118.05, 0, 0);
        Candle c3 = new Candle(114, 115, 95, 98, 0, 0);

        boolean result = BearishAbandonedBabyPattern.isAbandonedBaby(c1, c2, c3);

        assertFalse(result);
    }
}
