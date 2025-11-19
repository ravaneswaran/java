package rave.code.tech.analysis.pricerange.percentage;

public class AverageTrueRange {

    private double highPrice;
    private double lowPrice;
    private double previousClose;

    public AverageTrueRange(double highPrice, double lowPrice, double previousClose) {
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.previousClose = previousClose;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getTrueRange(){
        return 0;
    }

    public double get(){
        return 0;
    }

}
