package rave.code.tech.analysis.indicators.truerange;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.indicators.truerange.AverageTrueRange;
import rave.code.tech.analysis.indicators.truerange.TrueRange;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAverageTrueRange {

    @Test
    public void testGetValue() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105,110, 105, 100, 4));
        trueRanges.add(new TrueRange(220, 205,220, 205, 200, 4));
        trueRanges.add(new TrueRange(330, 305, 330, 305, 300, 4));
        trueRanges.add(new TrueRange(440, 405, 440, 405, 400, 4));
        trueRanges.add(new TrueRange(550, 505, 550, 505, 500, 4));
        trueRanges.add(new TrueRange(660, 605, 660, 605, 600, 4));
        trueRanges.add(new TrueRange(770, 705, 770, 705, 700, 4));
        trueRanges.add(new TrueRange(880, 805, 880, 805, 800, 4));
        trueRanges.add(new TrueRange(990, 905, 990, 905, 900, 4));
        trueRanges.add(new TrueRange(1010, 1005, 1010, 1005, 1000, 4));

        AverageTrueRange averageTrueRange = new AverageTrueRange(trueRanges);
        double averageTrueRangeValue = averageTrueRange.getValue();
        System.out.println("getValue ------------->>>>>> " + averageTrueRangeValue);

        assertTrue(0 != averageTrueRangeValue);
    }

    @Test
    public void testGetStopLoss() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105,110, 105, 100, 4));
        trueRanges.add(new TrueRange(220, 205,220, 205, 200, 4));
        trueRanges.add(new TrueRange(330, 305, 330, 305, 300, 4));
        trueRanges.add(new TrueRange(440, 405, 440, 405, 400, 4));
        trueRanges.add(new TrueRange(550, 505, 550, 505, 500, 4));
        trueRanges.add(new TrueRange(660, 605, 660, 605, 600, 4));
        trueRanges.add(new TrueRange(770, 705, 770, 705, 700, 4));
        trueRanges.add(new TrueRange(880, 805, 880, 805, 800, 4));
        trueRanges.add(new TrueRange(990, 905, 990, 905, 900, 4));
        trueRanges.add(new TrueRange(1010, 1005, 1010, 1005, 1000, 4));

        AverageTrueRange averageTrueRange = new AverageTrueRange(trueRanges);
        double stopLossValue = averageTrueRange.getStopLoss(1005);
        System.out.println("getStopLoss ------------->>>>>> " + stopLossValue);

        assertTrue(0 != stopLossValue);
    }

    @Test
    public void testGetUpperBreakout() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105,110, 105, 100, 4));
        trueRanges.add(new TrueRange(220, 205,220, 205, 200, 4));
        trueRanges.add(new TrueRange(330, 305, 330, 305, 300, 4));
        trueRanges.add(new TrueRange(440, 405, 440, 405, 400, 4));
        trueRanges.add(new TrueRange(550, 505, 550, 505, 500, 4));
        trueRanges.add(new TrueRange(660, 605, 660, 605, 600, 4));
        trueRanges.add(new TrueRange(770, 705, 770, 705, 700, 4));
        trueRanges.add(new TrueRange(880, 805, 880, 805, 800, 4));
        trueRanges.add(new TrueRange(990, 905, 990, 905, 900, 4));
        trueRanges.add(new TrueRange(1010, 1005, 1010, 1005, 1000, 4));

        AverageTrueRange averageTrueRange = new AverageTrueRange(trueRanges);
        double upperBreakOut = averageTrueRange.getUpperBreakout(1000);
        System.out.println("getUpperBreakout ------------->>>>>> " + upperBreakOut);

        assertTrue(0 != upperBreakOut);
    }

    @Test
    public void testGetLowerBreakout() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105,110, 105, 100, 4));
        trueRanges.add(new TrueRange(220, 205,220, 205, 200, 4));
        trueRanges.add(new TrueRange(330, 305, 330, 305, 300, 4));
        trueRanges.add(new TrueRange(440, 405, 440, 405, 400, 4));
        trueRanges.add(new TrueRange(550, 505, 550, 505, 500, 4));
        trueRanges.add(new TrueRange(660, 605, 660, 605, 600, 4));
        trueRanges.add(new TrueRange(770, 705, 770, 705, 700, 4));
        trueRanges.add(new TrueRange(880, 805, 880, 805, 800, 4));
        trueRanges.add(new TrueRange(990, 905, 990, 905, 900, 4));
        trueRanges.add(new TrueRange(1010, 1005, 1010, 1005, 1000, 4));

        AverageTrueRange averageTrueRange = new AverageTrueRange(trueRanges);
        double lowerBreakOut = averageTrueRange.getLowerBreakout(1000);
        System.out.println("getLowerBreakout ------------->>>>>> " + lowerBreakOut);

        assertTrue(0 != lowerBreakOut);
    }

}