package rave.code.tech.analysis.pricelimit;

public class LowerLimit extends Limit{

    public LowerLimit(double entryPrice) {
        super(entryPrice);
    }

    @Override
    public double getLimit(double targetPercentage) {
        return this.entryPrice - (this.entryPrice * targetPercentage);
    }
}
