package rave.code.tech.analysis.range.percentage;

public class UpperPriceRange extends PriceRange {

    public UpperPriceRange(double percentage) {
        super(percentage);
    }

    @Override
    public double getRange(double price) {
        return price * (1 + this.percentage / 100);
    }
}
