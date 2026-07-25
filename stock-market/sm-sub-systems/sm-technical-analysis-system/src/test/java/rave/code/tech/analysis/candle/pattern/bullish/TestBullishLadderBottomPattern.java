package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishLadderBottomPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishLadderBottomPattern {

    @Test
    public void testLadderBottomPattern(){
        Candle c1 = new Candle(100, 95, 101, 94,0);
        Candle c2 = new Candle(95, 90, 96, 89,0);
        Candle c3 = new Candle(90, 85, 91, 84,0);
        Candle c4 = new Candle(85, 82, 89, 81,0);
        Candle c5 = new Candle(83, 92, 93, 82,0);

        boolean result = BullishLadderBottomPattern.isLadderBottom(c1, c2, c3, c4, c5);

        assertTrue(result);
    }
}
