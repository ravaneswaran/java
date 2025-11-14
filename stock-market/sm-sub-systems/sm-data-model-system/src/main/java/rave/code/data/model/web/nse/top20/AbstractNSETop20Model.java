package rave.code.data.model.web.nse.top20;

import rave.code.data.model.web.nse.NSEStockModel;

public class AbstractNSETop20Model extends NSEStockModel {

    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double previousClosePrice;
    private double lastTradedPrice;
    private double percentageChange;
    private int volumeInShares;
    private double valueInLakhs;

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
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

    public double getPreviousClosePrice() {
        return previousClosePrice;
    }

    public void setPreviousClosePrice(double previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
    }

    public int getVolumeInShares() {
        return volumeInShares;
    }

    public void setVolumeInShares(int volumeInShares) {
        this.volumeInShares = volumeInShares;
    }

    public double getValueInLakhs() {
        return valueInLakhs;
    }

    public void setValueInLakhs(double valueInLakhs) {
        this.valueInLakhs = valueInLakhs;
    }

}
