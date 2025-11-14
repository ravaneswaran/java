package rave.code.data.model.web.nse;

public class NSESMEDetailModel extends NSEStockModel {

    private double highPrice;
    private double lowPrice;
    private double lastTradedPrice;
    private int volume;
    private double valueInLakhs;

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

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getValueInLakhs() {
        return valueInLakhs;
    }

    public void setValueInLakhs(double valueInLakhs) {
        this.valueInLakhs = valueInLakhs;
    }
}
