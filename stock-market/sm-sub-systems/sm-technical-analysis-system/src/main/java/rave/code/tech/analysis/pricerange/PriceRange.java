package rave.code.tech.analysis.pricerange;

public abstract class PriceRange {

    protected double percentage;

    public PriceRange(double percentage){
        this.percentage = percentage;
    }

    public abstract double getRange(double price);
}
