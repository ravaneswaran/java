package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishTweezerBottomPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishTweezerBottomPattern {

    @Test
    public void testTweezerBottomPattern(){
        Candle c1 = new Candle(100, 90, 101, 85,0);
        Candle c2 = new Candle(88, 97, 98, 85.1,0);

        boolean result = BullishTweezerBottomPattern.isTweezerBottom(c1, c2);

        assertTrue(result);
    }
}