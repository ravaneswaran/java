package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishMorningStarDetector {

    @Test
    public void testMorningStar() {
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(89, 88, 90, 87);
        Candle c3 = new Candle(89, 98, 99, 88);

        boolean result = BullishMorningStarDetector.isMorningStar(c1, c2, c3);

        assertTrue(result);
    }
}
