package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishSeparatingLinesDetector {

    @Test
    public void testBullishSeparatingLinesDetector(){
        Candle c1 = new Candle(100, 95, 102, 94);
        Candle c2 = new Candle(100.05, 108, 109, 99);

        boolean result = BullishSeparatingLinesDetector.isSeparatingLines(c1, c2);

        assertTrue(result);
    }

}
