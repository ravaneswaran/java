package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishInvertedHammerPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBullishInvertedHammerPattern {

    @Test
    public void testInvertedHammerPattern() {
        Candle candle = new Candle(100, 102, 115, 99);

        boolean result =
                BullishInvertedHammerPattern.isInvertedHammer(candle);

        assertFalse(result);

    }
}
