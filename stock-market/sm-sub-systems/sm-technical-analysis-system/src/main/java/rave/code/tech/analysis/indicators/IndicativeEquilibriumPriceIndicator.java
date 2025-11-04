package rave.code.tech.analysis.indicators;

public class IndicativeEquilibriumPriceIndicator {

    private double oldPrice;
    private double newPrice;

    public IndicativeEquilibriumPriceIndicator(double oldPrice, double newPrice){
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public double getPricePercentage(){
        return ((this.newPrice - this.oldPrice) / this.newPrice) * 100;
    }

    public boolean isPricePercentagePositive(){
        return 0 < this.getPricePercentage();
    }

    public boolean isPricePercentageZero(){
        return 0 == this.getPricePercentage();
    }

}
