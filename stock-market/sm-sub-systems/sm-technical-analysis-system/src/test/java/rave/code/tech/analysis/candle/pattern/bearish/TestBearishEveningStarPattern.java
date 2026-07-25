package rave.code.tech.analysis.candle.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishEveningStarPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishEveningStarPattern {

    @Test
    public void testBearishEveningStarPattern(){
        Candle c1 = new Candle(100, 112, 99, 110,0);
        Candle c2 = new Candle(111, 113, 109, 112,0);
        Candle c3 = new Candle(111, 112, 95, 98,0);

        boolean result = BearishEveningStarPattern.isEveningStar(c1, c2, c3);

        assertFalse(result);
    }
}
