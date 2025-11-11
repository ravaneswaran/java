package rave.code.tech.analysis.pricerange.percentage;

import rave.code.tech.analysis.pricerange.LowerPriceRange;
import rave.code.tech.analysis.pricerange.UpperPriceRange;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentagePriceRange {

    private double percentage;
    private double price;

    public PercentagePriceRange(double percentage, double price) {
        this.percentage = percentage;
        this.price = price;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getPrice() {
        return price;
    }

    public double getUpperPriceRange() {
        return new BigDecimal(new UpperPriceRange(this.percentage).getRange(this.price))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getLowerPriceRange() {
        return new BigDecimal(new LowerPriceRange(this.percentage).getRange(this.price))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getStopLoss() {
        return new BigDecimal(this.price * (1 - percentage / 100))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public String getRiskReward() {
        return "0:0";
    }
}
