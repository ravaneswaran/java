package rave.code.tech.analysis.indicators.truerange;

import java.util.List;

public class WilderAverageTrueRange extends AverageTrueRange {

    public WilderAverageTrueRange(List<TrueRange> trueRanges) {
        super(trueRanges);
    }

    @Override
    public double getValue() {
        int size = this.trueRanges.size();
        double sum = 0;
        for (int index = 0; index < (size - 1); index++) {
            sum += this.trueRanges.get(index).getMax();
        }

        return ((sum / size - 1) + this.trueRanges.get(size - 1).getMax()) / size;
    }
}
