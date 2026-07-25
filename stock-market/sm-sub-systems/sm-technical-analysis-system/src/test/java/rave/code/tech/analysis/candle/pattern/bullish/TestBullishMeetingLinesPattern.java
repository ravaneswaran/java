package rave.code.tech.analysis.candle.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.Candle;
import rave.code.tech.analysis.pattern.bullish.BullishMeetingLinesPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBullishMeetingLinesPattern {

    @Test
    public void testTestMeetingLinesPattern(){
        Candle c1 = new Candle(100, 90, 101, 89,0);
        Candle c2 = new Candle(85, 90.10, 91, 84,0);

        boolean result = BullishMeetingLinesPattern.isMeetingLines(c1, c2);

        assertTrue(result);
    }

}
