package rave.code.tech.analysis.pricerange.percentage.truerange;

import java.util.List;

public class AverageTrueRange {

    protected List<TrueRange> trueRanges;

    public AverageTrueRange(List<TrueRange> trueRanges) {
        this.trueRanges = trueRanges;
    }

    public double getValue() {
        int size = this.trueRanges.size();
        double sum = 0;
        for (TrueRange trueRange : this.trueRanges) {
            sum += trueRange.getMax();
        }
        return sum / size;
    }

    public double getStopLoss(double entryPrice) {
        return entryPrice - (this.getValue() * 1.5);
    }

    public double getUpperBreakout(double previousClose) {
        return previousClose + (2 * this.getValue());
    }

    public double getLowerBreakout(double previousClose) {
        return previousClose - (2 * this.getValue());
    }

    public double getPositionSize(double riskPerTrade, double factor) {
        return riskPerTrade / (this.getValue() * factor);
    }
}
