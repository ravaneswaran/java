package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishLadderBottomPattern {

    @Test
    public void testLadderBottomPattern(){
        Candle c1 = new Candle(100, 95, 101, 94);
        Candle c2 = new Candle(95, 90, 96, 89);
        Candle c3 = new Candle(90, 85, 91, 84);
        Candle c4 = new Candle(85, 82, 89, 81);
        Candle c5 = new Candle(83, 92, 93, 82);

        boolean result = BullishLadderBottomPattern.isLadderBottom(c1, c2, c3, c4, c5);

        assertTrue(result);
    }
}
