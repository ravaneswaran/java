package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishThreeInsideDownPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishThreeInsideDownPattern {

    @Test
    public void testBearishThreeInsideDownPattern() {
        Candle c1 = new Candle(100, 122, 99, 120, 0, 0);
        Candle c2 = new Candle(116, 117, 109, 111, 0, 0);
        Candle c3 = new Candle(110, 112, 95, 100, 0, 0);

        boolean result = BearishThreeInsideDownPattern.isThreeInsideDown(c1, c2, c3);

        assertFalse(result);
    }
}
