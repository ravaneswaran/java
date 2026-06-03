package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestThreeLineStrikeDetector {

    @Test
    public void testTestThreeLineStrikeDetector() {
        Candle c1 = new Candle(100, 105, 106, 99);
        Candle c2 = new Candle(104, 110, 111, 103);
        Candle c3 = new Candle(109, 115, 116, 108);
        Candle c4 = new Candle(117, 98, 118, 97);

        boolean result = ThreeLineStrikeDetector.isBullishThreeLineStrike(c1, c2, c3, c4);

        assertTrue(result);
    }

}
