package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMeetingLinesDetector {

    @Test
    public void testTestMeetingLinesDetector(){
        Candle c1 = new Candle(100, 90, 101, 89);
        Candle c2 = new Candle(85, 90.10, 91, 84);

        boolean result = MeetingLinesDetector.isBullishMeetingLines(c1, c2);

        assertTrue(result);
    }

}
