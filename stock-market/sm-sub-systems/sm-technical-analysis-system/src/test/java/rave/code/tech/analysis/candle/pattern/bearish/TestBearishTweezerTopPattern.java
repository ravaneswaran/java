package rave.code.tech.analysis.candle.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishTweezerTopPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishTweezerTopPattern {

    @Test
    public void testBearishTweezerTopPattern(){
        Candle c1 = new Candle(100, 120, 98, 118,0);
        Candle c2 = new Candle(119, 120.05, 105, 108,0);

        boolean result = BearishTweezerTopPattern.isTweezerTop(c1, c2);

        assertFalse(result);
    }
}
