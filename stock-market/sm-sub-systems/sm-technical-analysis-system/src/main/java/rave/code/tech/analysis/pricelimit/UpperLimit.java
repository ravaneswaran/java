package rave.code.tech.analysis.pricelimit;

public class UpperLimit extends Limit{

    public UpperLimit(double entryPrice) {
        super(entryPrice);
    }

    @Override
    public double getLimit(double targetPercentage) {
        return this.entryPrice + (entryPrice * targetPercentage);
    }
}
