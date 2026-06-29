package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bullish.BullishPiercingLinePattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishPiercingLinePattern {

    @Test
    public void testPiercingLinePattern(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(88, 96, 97, 87);

        boolean result = BullishPiercingLinePattern.isPiercingLine(c1, c2);

        assertTrue(result);
    }
}
