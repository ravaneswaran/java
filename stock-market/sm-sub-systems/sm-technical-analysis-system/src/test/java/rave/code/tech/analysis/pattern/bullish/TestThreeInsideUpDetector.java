package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestThreeInsideUpDetector {

    @Test
    public void testTestThreeInsideUpDetector(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(92, 96, 97, 91);
        Candle c3 = new Candle(95, 104, 105, 94);

        boolean result = ThreeInsideUpDetector.isThreeInsideUp(c1, c2, c3);

        assertTrue(result);
    }
}
