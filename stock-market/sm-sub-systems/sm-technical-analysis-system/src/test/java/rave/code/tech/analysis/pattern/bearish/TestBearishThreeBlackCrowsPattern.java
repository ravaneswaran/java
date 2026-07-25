package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishThreeBlackCrowsPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishThreeBlackCrowsPattern {

    @Test
    public void testThreeBlackCrowsPattern() {
        Candle c1 = new Candle(120, 122, 112, 114, 0, 0);
        Candle c2 = new Candle(116, 118, 106, 108, 0, 0);
        Candle c3 = new Candle(110, 112, 100, 102, 0, 0);

        boolean result = BearishThreeBlackCrowsPattern.isThreeBlackCrows(c1, c2, c3);

        assertFalse(result);
    }

}
