package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishThreeWhiteSoldiersPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishThreeWhiteSoldiersPattern {

    @Test
    public void testThreeWhiteSoldiersPattern() {
        Candle c1 = new Candle(100, 105, 106, 99);
        Candle c2 = new Candle(103, 110, 111, 102);
        Candle c3 = new Candle(108, 116, 117, 107);

        boolean result =
                BullishThreeWhiteSoldiersPattern.isThreeWhiteSoldiers(
                        c1, c2, c3);

        assertTrue(result);
    }

}
