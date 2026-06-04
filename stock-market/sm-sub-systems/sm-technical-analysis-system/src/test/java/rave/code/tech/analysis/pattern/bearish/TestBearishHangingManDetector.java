package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishHangingManDetector {

    @Test
    public void testHangingManDetector(){
        Candle candle = new Candle(100, 102, 85, 101);

        boolean result = BearishHangingManDetector.isHangingMan(candle);

        assertFalse(result);
    }
}
