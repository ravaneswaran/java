package rave.code.tech.analysis.pricerange.percentage;

public class LowerPriceRange extends PriceRange {

    public LowerPriceRange(double percentage) {
        super(percentage);
    }

    @Override
    public double getRange(double price) {
        return price * (1 - this.percentage / 100);
    }

}
