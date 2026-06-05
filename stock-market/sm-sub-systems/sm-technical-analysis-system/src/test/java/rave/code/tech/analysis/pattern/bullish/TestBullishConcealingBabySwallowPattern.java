package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishConcealingBabySwallowPattern {

    @Test
    public void testConcealingBabySwallowPattern() {
        Candle c1 = new Candle(100, 90, 100, 90);
        Candle c2 = new Candle(89, 80, 89, 80);
        Candle c3 = new Candle(78, 74, 79, 73);
        Candle c4 = new Candle(77, 70, 81, 69);

        boolean result = BullishConcealingBabySwallowPattern.isConcealingBabySwallow(c1, c2, c3, c4);

        assertFalse(result);
    }
}
