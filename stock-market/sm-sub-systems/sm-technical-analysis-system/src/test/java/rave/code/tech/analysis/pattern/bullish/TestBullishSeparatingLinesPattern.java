package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishSeparatingLinesPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishSeparatingLinesPattern {

    @Test
    public void testBullishSeparatingLinesPattern() {
        Candle c1 = new Candle(100, 95, 102, 94, 0, 0);
        Candle c2 = new Candle(100.05, 108, 109, 99, 0, 0);

        boolean result = BullishSeparatingLinesPattern.isSeparatingLines(c1, c2);

        assertTrue(result);
    }

}
