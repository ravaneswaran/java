package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishTweezerBottomDetector {

    @Test
    public void testTweezerBottomDetector(){
        Candle c1 = new Candle(100, 90, 101, 85);
        Candle c2 = new Candle(88, 97, 98, 85.1);

        boolean result = BullishTweezerBottomDetector.isTweezerBottom(c1, c2);

        assertTrue(result);
    }
}