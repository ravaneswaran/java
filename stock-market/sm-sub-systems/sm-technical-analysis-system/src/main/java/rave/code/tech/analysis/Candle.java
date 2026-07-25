package rave.code.tech.analysis;

public class Candle {

    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;
    private double percentageChange;
    private double previousClose;

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

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getLastTradedPrice() {
        return this.getClosePrice();
    }

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
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
