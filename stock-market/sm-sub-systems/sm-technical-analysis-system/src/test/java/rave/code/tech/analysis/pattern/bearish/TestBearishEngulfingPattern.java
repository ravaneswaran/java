package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishEngulfingPattern {

    @Test
    public void testBearishEngulfingPattern(){
        Candle c1 = new Candle(100, 111, 99, 110);
        Candle c2 = new Candle(112, 113, 95, 98);

        boolean result = BearishEngulfingPattern.isEngulfing(c1, c2);

        assertFalse(result);
    }
}
