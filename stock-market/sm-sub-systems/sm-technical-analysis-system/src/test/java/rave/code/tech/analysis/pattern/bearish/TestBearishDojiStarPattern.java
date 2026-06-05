package rave.code.tech.analysis.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishDojiStarPattern {

    @Test
    public void testBearishDojiStarPattern(){
        Candle c1 = new Candle(100, 115, 99, 112);
        Candle c2 = new Candle(114, 116, 113, 114.1);
        Candle c3 = new Candle(113, 114, 95, 98);

        boolean result = BearishDojiStarPattern.isDojiStar(c1, c2, c3);

        assertFalse(result);
    }
}
