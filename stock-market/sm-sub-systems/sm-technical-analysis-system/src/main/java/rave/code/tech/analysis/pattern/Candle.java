package rave.code.tech.analysis.pattern;

public  class Candle {

    double open;
    double close;
    double high;
    double low;

    public Candle(double open, double close, double high, double low) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public double bodySize() {
        return Math.abs(open - close);
    }

    public double lowerShadow() {
        return Math.min(open, close) - low;
    }

    public double upperShadow() {
        return high - Math.max(open, close);
    }

    public boolean isBullish() {
        return close > open;
    }

    public double totalRange() {
        return high - low;
    }

    public boolean isBearish() {
        return close < open;
    }

    public boolean isDoji() {
        return bodySize()
                <= (range() * 0.1);
    }

    public double range() {
        return high - low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }
}