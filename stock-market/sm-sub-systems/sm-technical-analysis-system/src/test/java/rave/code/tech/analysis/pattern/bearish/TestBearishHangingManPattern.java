package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishHangingManPattern {

    @Test
    public void testHangingManPattern(){
        Candle candle = new Candle(100, 102, 85, 101);

        boolean result = BearishHangingManPattern.isHangingMan(candle);

        assertFalse(result);
    }
}
