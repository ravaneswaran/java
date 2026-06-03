package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishHarami {

    @Test
    public void testBullishHarami(){
        Candle c1 = new Candle(100, 90, 102, 88);
        Candle c2 = new Candle(92, 96, 97, 91);

        boolean result = BullishHaramiDetector.isBullishHarami(c1, c2);

        assertTrue(result);
    }
}
