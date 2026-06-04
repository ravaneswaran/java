package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishKickerDetector {

    @Test
    public void test(){
        Candle c1 = new Candle(100, 115, 99, 112);
        Candle c2 = new Candle(95, 96, 80, 82);

        boolean result = BearishKickerDetector.isKicker(c1, c2);

        assertFalse(result);
    }

}
