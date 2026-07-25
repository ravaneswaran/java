package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishDarkCloudCoverPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishDarkCloudCoverPattern {

    @Test
    public void testBearishDarkCloudCoverPattern() {
        Candle c1 = new Candle(100, 115, 99, 112, 0, 0);
        Candle c2 = new Candle(114, 116, 101, 104, 0, 0);

        boolean result = BearishDarkCloudCoverPattern.isDarkCloudCover(c1, c2);

        assertFalse(result);
    }
}
