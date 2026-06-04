package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishShootingStarDetector {

    @Test
    public void testShootingStarDetector(){
        Candle candle = new Candle(100, 120, 99, 102);
        boolean result = BearishShootingStarDetector.isShootingStar(candle);
        assertFalse(result);
    }
}
