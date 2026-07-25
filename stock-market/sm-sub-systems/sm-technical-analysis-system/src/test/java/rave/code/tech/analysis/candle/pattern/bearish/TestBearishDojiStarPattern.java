package rave.code.tech.analysis.candle.pattern.bearish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bearish.BearishDojiStarPattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBearishDojiStarPattern {

    @Test
    public void testBearishDojiStarPattern(){
        Candle c1 = new Candle(100, 115, 99, 112,0);
        Candle c2 = new Candle(114, 116, 113, 114.1,0);
        Candle c3 = new Candle(113, 114, 95, 98,0);

        boolean result = BearishDojiStarPattern.isDojiStar(c1, c2, c3);

        assertFalse(result);
    }
}
