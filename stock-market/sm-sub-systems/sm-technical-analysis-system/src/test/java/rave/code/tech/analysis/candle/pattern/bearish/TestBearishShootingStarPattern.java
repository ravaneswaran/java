package rave.code.tech.analysis.candle.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.candle.pattern.Candle;
import rave.code.tech.analysis.candle.pattern.bearish.BearishShootingStarPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishShootingStarPattern {

    @Test
    public void testShootingStarPattern(){
        Candle candle = new Candle(100, 120, 99, 102);
        boolean result = BearishShootingStarPattern.isShootingStar(candle);
        assertFalse(result);
    }
}
