package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishTweezerTopDetector {

    @Test
    public void testBearishTweezerTopDetector(){
        Candle c1 = new Candle(100, 120, 98, 118);
        Candle c2 = new Candle(119, 120.05, 105, 108);

        boolean result = BearishTweezerTopDetector.isTweezerTop(c1, c2);

        assertFalse(result);
    }
}
