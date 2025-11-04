package rave.code.tech.analysis.stoploss;

public class StopLoss {

    protected double entryPrice;

    public StopLoss(double entryPrice){
        this.entryPrice = entryPrice;
    }

    public double getBuyStopLossPrice(double targetPercentage){
        return this.entryPrice - (this.entryPrice * targetPercentage);
    }

    public double getSellStopLossPrice(double targetPercentage){
        return this.entryPrice + (this.entryPrice * targetPercentage);
    }

}
