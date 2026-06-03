package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInvertedHammerDetector {

    @Test
    public void testInvertedHammerDetector() {
        Candle candle = new Candle(100, 102, 115, 99);

        boolean result =
                InvertedHammerDetector.isInvertedHammer(candle);

        assertFalse(result);

    }
}
