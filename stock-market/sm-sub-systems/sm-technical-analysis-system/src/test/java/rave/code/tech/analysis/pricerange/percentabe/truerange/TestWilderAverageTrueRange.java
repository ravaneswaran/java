package rave.code.tech.analysis.pricerange.percentabe.truerange;

import org.junit.jupiter.api.Test;
import rave.code.tech.analysis.pricerange.percentage.truerange.AverageTrueRange;
import rave.code.tech.analysis.pricerange.percentage.truerange.TrueRange;
import rave.code.tech.analysis.pricerange.percentage.truerange.WilderAverageTrueRange;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWilderAverageTrueRange {

    @Test
    public void testGetValue() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105, 100));
        trueRanges.add(new TrueRange(220, 205, 200));
        trueRanges.add(new TrueRange(330, 305, 300));
        trueRanges.add(new TrueRange(440, 405, 400));
        trueRanges.add(new TrueRange(550, 505, 500));
        trueRanges.add(new TrueRange(660, 605, 600));
        trueRanges.add(new TrueRange(770, 705, 700));
        trueRanges.add(new TrueRange(880, 805, 800));
        trueRanges.add(new TrueRange(990, 905, 900));
        trueRanges.add(new TrueRange(1010, 1005, 1000));

        AverageTrueRange averageTrueRange = new WilderAverageTrueRange(trueRanges);
        double averageTrueRangeValue = averageTrueRange.getValue();
        System.out.println("getValue ------------->>>>>> " + averageTrueRangeValue);

        assertTrue(0 != averageTrueRangeValue);
    }

    @Test
    public void testGetStopLoss() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105, 100));
        trueRanges.add(new TrueRange(220, 205, 200));
        trueRanges.add(new TrueRange(330, 305, 300));
        trueRanges.add(new TrueRange(440, 405, 400));
        trueRanges.add(new TrueRange(550, 505, 500));
        trueRanges.add(new TrueRange(660, 605, 600));
        trueRanges.add(new TrueRange(770, 705, 700));
        trueRanges.add(new TrueRange(880, 805, 800));
        trueRanges.add(new TrueRange(990, 905, 900));
        trueRanges.add(new TrueRange(1010, 1005, 1000));

        AverageTrueRange averageTrueRange = new WilderAverageTrueRange(trueRanges);
        double stopLossValue = averageTrueRange.getStopLoss(1005);
        System.out.println("getStopLoss ------------->>>>>> " + stopLossValue);

        assertTrue(0 != stopLossValue);
    }

    @Test
    public void testGetUpperBreakout() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105, 100));
        trueRanges.add(new TrueRange(220, 205, 200));
        trueRanges.add(new TrueRange(330, 305, 300));
        trueRanges.add(new TrueRange(440, 405, 400));
        trueRanges.add(new TrueRange(550, 505, 500));
        trueRanges.add(new TrueRange(660, 605, 600));
        trueRanges.add(new TrueRange(770, 705, 700));
        trueRanges.add(new TrueRange(880, 805, 800));
        trueRanges.add(new TrueRange(990, 905, 900));
        trueRanges.add(new TrueRange(1010, 1005, 1000));

        AverageTrueRange averageTrueRange = new WilderAverageTrueRange(trueRanges);
        double upperBreakOut = averageTrueRange.getUpperBreakout(1000);
        System.out.println("getUpperBreakout ------------->>>>>> " + upperBreakOut);

        assertTrue(0 != upperBreakOut);
    }

    @Test
    public void testGetLowerBreakout() {

        List<TrueRange> trueRanges = new ArrayList<>();
        trueRanges.add(new TrueRange(110, 105, 100));
        trueRanges.add(new TrueRange(220, 205, 200));
        trueRanges.add(new TrueRange(330, 305, 300));
        trueRanges.add(new TrueRange(440, 405, 400));
        trueRanges.add(new TrueRange(550, 505, 500));
        trueRanges.add(new TrueRange(660, 605, 600));
        trueRanges.add(new TrueRange(770, 705, 700));
        trueRanges.add(new TrueRange(880, 805, 800));
        trueRanges.add(new TrueRange(990, 905, 900));
        trueRanges.add(new TrueRange(1010, 1005, 1000));

        AverageTrueRange averageTrueRange = new WilderAverageTrueRange(trueRanges);
        double lowerBreakOut = averageTrueRange.getLowerBreakout(1000);
        System.out.println("getLowerBreakout ------------->>>>>> " + lowerBreakOut);

        assertTrue(0 != lowerBreakOut);
    }
}


