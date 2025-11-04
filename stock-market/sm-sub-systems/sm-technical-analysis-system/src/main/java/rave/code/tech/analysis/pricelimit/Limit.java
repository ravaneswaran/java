package rave.code.tech.analysis.pricelimit;

public abstract class Limit {

    protected double entryPrice;

    public Limit(double entryPrice){
        this.entryPrice = entryPrice;
    }

    public abstract double getLimit(double targetPercentage);

}
