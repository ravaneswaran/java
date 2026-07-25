package rave.code.tech.analysis.candle.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishThreeOutsideDownPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishThreeOutsideDownPattern {

    @Test
    public void test(){
        Candle c1 = new Candle(100, 111, 99, 110,0);
        Candle c2 = new Candle(112, 114, 95, 98,0);
        Candle c3 = new Candle(97, 100, 90, 92,0);

        boolean result = BearishThreeOutsideDownPattern.isThreeOutsideDown(c1, c2, c3);

        assertFalse(result);
    }
}
