package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishMorningStarPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishMorningStarPattern {

    @Test
    public void testMorningStarPattern() {
        Candle c1 = new Candle(100, 90, 101, 89, 0, 0);
        Candle c2 = new Candle(89, 88, 90, 87, 0, 0);
        Candle c3 = new Candle(89, 98, 99, 88, 0, 0);

        boolean result = BullishMorningStarPattern.isMorningStar(c1, c2, c3);

        assertTrue(result);
    }
}
