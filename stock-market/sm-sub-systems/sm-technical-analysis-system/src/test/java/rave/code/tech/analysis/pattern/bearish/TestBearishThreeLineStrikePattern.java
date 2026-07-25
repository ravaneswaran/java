package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishThreeLineStrikePattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishThreeLineStrikePattern {

    @Test
    public void testBearishThreeLineStrikePattern() {
        Candle c1 = new Candle(120, 122, 114, 115, 0, 0);
        Candle c2 = new Candle(114, 116, 108, 109, 0, 0);
        Candle c3 = new Candle(108, 110, 102, 103, 0, 0);
        Candle c4 = new Candle(101, 126, 100, 124, 0, 0);

        boolean result = BearishThreeLineStrikePattern.isThreeLineStrike(c1, c2, c3, c4);

        assertFalse(result);
    }
}
