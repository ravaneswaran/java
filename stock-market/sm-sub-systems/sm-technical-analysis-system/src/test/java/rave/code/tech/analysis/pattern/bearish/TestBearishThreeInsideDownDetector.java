package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishThreeInsideDownDetector {

    @Test
    public void testBearishThreeInsideDownDetector(){
        Candle c1 = new Candle(100, 122, 99, 120);
        Candle c2 = new Candle(116, 117, 109, 111);
        Candle c3 = new Candle(110, 112, 95, 100);

        boolean result = BearishThreeInsideDownDetector.isThreeInsideDown(c1, c2, c3);

        assertFalse(result);
    }
}
