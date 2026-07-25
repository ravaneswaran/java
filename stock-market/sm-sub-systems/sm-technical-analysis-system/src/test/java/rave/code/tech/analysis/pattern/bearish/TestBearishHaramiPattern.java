package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishHaramiPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishHaramiPattern {

    @Test
    public void testBearishHaramiPattern() {
        Candle c1 = new Candle(100, 121, 99, 120, 0, 0);
        Candle c2 = new Candle(115, 116, 108, 110, 0, 0);

        boolean result = BearishHaramiPattern.isHarami(c1, c2);

        assertFalse(result);
    }
}
