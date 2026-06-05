package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishHaramiPattern {

    @Test
    public void testBearishHaramiPattern(){
        Candle c1 = new Candle(100, 121, 99, 120);
        Candle c2 = new Candle(115, 116, 108, 110);

        boolean result = BearishHaramiPattern.isHarami(c1, c2);

        assertFalse(result);
    }
}
