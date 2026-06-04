package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishUpsideGapTwoCrowsDetector {

    @Test
    public void testUpsideGapTwoCrowsDetector(){
        Candle c1 = new Candle(100, 112, 99, 110);
        Candle c2 = new Candle(114, 116, 111, 112);
        Candle c3 = new Candle(117, 118, 111, 111);

        boolean result = BearishUpsideGapTwoCrowsDetector.isUpsideGapTwoCrows(c1, c2, c3);

        assertFalse(result);
    }
}
