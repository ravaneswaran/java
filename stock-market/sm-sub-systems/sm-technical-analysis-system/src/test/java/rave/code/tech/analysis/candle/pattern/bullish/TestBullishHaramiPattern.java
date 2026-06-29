package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishHaramiPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishHaramiPattern {

    @Test
    public void testBullishHaramiPattern(){
        Candle c1 = new Candle(100, 90, 102, 88);
        Candle c2 = new Candle(92, 96, 97, 91);

        boolean result = BullishHaramiPattern.isHarami(c1, c2);

        assertTrue(result);
    }
}
