package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishMatHoldPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishMatHoldPattern {

    @Test
    public void testBearishMatHoldPattern() {
        Candle c1 = new Candle(120, 121, 100, 102, 0, 0);
        Candle c2 = new Candle(103, 106, 102, 105, 0, 0);
        Candle c3 = new Candle(105, 108, 104, 107, 0, 0);
        Candle c4 = new Candle(107, 109, 105, 106, 0, 0);
        Candle c5 = new Candle(105, 106, 90, 95, 0, 0);

        boolean result = BearishMatHoldPattern.isMatHold(c1, c2, c3, c4, c5);

        assertFalse(result);
    }

}
