package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishPiercingLineDetector {

    @Test
    public void testPiercingLine(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(88, 96, 97, 87);

        boolean result = BullishPiercingLineDetector.isPiercingLine(c1, c2);

        assertTrue(result);
    }
}
