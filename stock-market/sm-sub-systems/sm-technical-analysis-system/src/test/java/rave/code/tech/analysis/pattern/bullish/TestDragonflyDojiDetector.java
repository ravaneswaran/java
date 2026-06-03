package rave.code.tech.analysis.pattern.bullish;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pattern.Candle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDragonflyDojiDetector {

    @Test
    public void testDragonflyDojiDetector() {
        Candle candle = new Candle(100, 101, 101, 85);
        boolean result = DragonflyDojiDetector.isDragonflyDoji(candle);

        assertTrue(result);

    }
}
