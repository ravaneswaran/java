package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishMatHoldPattern {

    @Test
    public void testBearishMatHoldPattern(){
        Candle c1 = new Candle(120,121,100,102);
        Candle c2 = new Candle(103,106,102,105);
        Candle c3 = new Candle(105,108,104,107);
        Candle c4 = new Candle(107,109,105,106);
        Candle c5 = new Candle(105,106,90,95);

        boolean result = BearishMatHoldPattern.isMatHold(c1,c2,c3,c4,c5);

        assertFalse(result);
    }

}
