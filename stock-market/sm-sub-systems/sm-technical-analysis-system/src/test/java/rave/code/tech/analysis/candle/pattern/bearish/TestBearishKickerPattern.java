package rave.code.tech.analysis.candle.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bearish.BearishKickerPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishKickerPattern {

    @Test
    public void testBearishKickerPattern(){
        Candle c1 = new Candle(100, 115, 99, 112);
        Candle c2 = new Candle(95, 96, 80, 82);

        boolean result = BearishKickerPattern.isKicker(c1, c2);

        assertFalse(result);
    }

}
