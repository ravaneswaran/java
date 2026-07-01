package rave.code.tech.analysis.candle;

public class Candle {

    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;

    public Candle(){
    }

    public Candle(double openPrice, double highPrice, double lowPrice,  double closePrice){
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
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

    public int getLTPProgress(Candle previousCandle) {
        return Double.compare(this.getClosePrice(), previousCandle.getClosePrice());
    }
}
