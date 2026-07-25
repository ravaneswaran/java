package rave.code.tech.analysis.range.percentage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentagePriceRange {

    private double percentage;
    private double openPrice;
    private double lastTradedPrice;

    public PercentagePriceRange(double percentage, double openPrice, double lastTradedPrice) {
        this.percentage = percentage;
        this.openPrice = openPrice;
        this.lastTradedPrice = lastTradedPrice;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public double getOpenPrice() {
        return this.openPrice;
    }

    public double getUpperPriceRange() {
        return new BigDecimal(new UpperPriceRange(this.getPercentage()).getRange(this.getOpenPrice()))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getLowerPriceRange() {
        return new BigDecimal(new LowerPriceRange(this.getPercentage()).getRange(this.getOpenPrice()))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getLastTradedPrice() {
        return this.lastTradedPrice;
    }

    public double getStopLoss() {
        return new BigDecimal(this.getLastTradedPrice() * (1 - this.getPercentage() / 100))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getTargetPrice() {
        return new BigDecimal(this.getLastTradedPrice() + (this.getLastTradedPrice() * this.getPercentage() / 100))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public String getRiskReward() {
        double risk = new BigDecimal(this.getTargetPrice() - this.getStopLoss())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        double reward = new BigDecimal(this.getTargetPrice() - this.getOpenPrice())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        double riskRewardRatio = 0;
        if (reward > 0) {
            riskRewardRatio = new BigDecimal(risk / reward)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        }

        return String.format("%s", riskRewardRatio);
    }

    public double getCapitalRequired() {
        return new BigDecimal(100 * this.getTargetPrice())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getProfit() {
        return new BigDecimal(this.getCapitalRequired() - (this.getOpenPrice() * 100))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public boolean getHasLTPEqualsOrOverTargetPrice(){
        return this.getLastTradedPrice() >= this.getTargetPrice();
    }
}
