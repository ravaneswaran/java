package rave.code.tech.analysis;

public class Candle {

    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;
    private double percentageChange;
    private double previousClose;
    private int volume;

    public Candle(){
    }

    public Candle(double openPrice, double closePrice, double highPrice, double lowPrice, double previousClose, double percentageChange){
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.previousClose = previousClose;
        this.percentageChange = percentageChange;
    }

    public double bodySize() {
        return Math.abs(this.openPrice - this.closePrice);
    }

    public double lowerShadow() {
        return Math.min(this.openPrice, this.closePrice) - this.lowPrice;
    }

    public double upperShadow() {
        return this.highPrice - Math.max(this.openPrice, this.closePrice);
    }

    public boolean isBullish() {
        return this.closePrice > this.openPrice;
    }

    public double totalRange() {
        return this.highPrice - this.lowPrice;
    }

    public boolean isBearish() {
        return this.closePrice < this.openPrice;
    }

    public boolean isDoji() {
        return bodySize()
                <= (range() * 0.1);
    }

    public double range() {
        return this.highPrice - this.lowPrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public Candle setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public Candle setHighPrice(double highPrice) {
        this.highPrice = highPrice;
        return this;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public Candle setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
        return this;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public Candle setClosePrice(double closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public Candle setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
        return this;
    }

    public double getLastTradedPrice() {
        return this.getClosePrice();
    }

    public double getPercentageChange() {
        return percentageChange;
    }

    public Candle setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
        return this;
    }

    public int getVolume() {
        return volume;
    }

    public Candle setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public int getStrength() {
        double body = Math.abs(this.closePrice = this.openPrice);
        double range = this.highPrice = this.lowPrice;
        double bodyRatio = body / range;

        if (bodyRatio > 0.7) {
            return 1;
        } else if (bodyRatio >= 0.4 && bodyRatio < 0.7) {
            return 0;
        } else {
            return -1;
        }
    }

    public int getDirection() {
        if (this.closePrice > this.openPrice)
            return 1;
        else if (this.closePrice < this.openPrice)
            return -1;
        else
            return 0;
    }

    public int getProgress(Candle previousCandle) {
        if ((this.highPrice > previousCandle.getHighPrice()) && this.lowPrice > previousCandle.getLowPrice()) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getLastTradedPriceProgress(Candle previousCandle) {
        return Double.compare(this.getClosePrice(), previousCandle.getClosePrice());
    }
}
