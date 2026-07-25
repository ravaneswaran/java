package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishEngulfingPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishEngulfingPattern {

    @Test
    public void testBearishEngulfingPattern() {
        Candle c1 = new Candle(100, 111, 99, 110, 0, 0);
        Candle c2 = new Candle(112, 113, 95, 98, 0, 0);

        boolean result = BearishEngulfingPattern.isEngulfing(c1, c2);

        assertFalse(result);
    }
}
