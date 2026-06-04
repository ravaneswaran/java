package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBearishThreeBlackCrowsDetector {

    @Test
    public void testThreeBlackCrowsDetector(){
        Candle c1 = new Candle(120, 122, 112, 114);
        Candle c2 = new Candle(116, 118, 106, 108);
        Candle c3 = new Candle(110, 112, 100, 102);

        boolean result = BearishThreeBlackCrowsDetector.isThreeBlackCrows(c1, c2, c3);

        assertFalse(result);
    }

}
