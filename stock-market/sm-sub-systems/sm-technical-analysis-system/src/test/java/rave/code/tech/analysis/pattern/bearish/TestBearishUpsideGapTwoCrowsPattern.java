package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishUpsideGapTwoCrowsPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishUpsideGapTwoCrowsPattern {

    @Test
    public void testUpsideGapTwoCrowsPattern() {
        Candle c1 = new Candle(100, 112, 99, 110, 0, 0);
        Candle c2 = new Candle(114, 116, 111, 112, 0, 0);
        Candle c3 = new Candle(117, 118, 111, 111, 0, 0);

        boolean result = BearishUpsideGapTwoCrowsPattern.isUpsideGapTwoCrows(c1, c2, c3);

        assertFalse(result);
    }
}
