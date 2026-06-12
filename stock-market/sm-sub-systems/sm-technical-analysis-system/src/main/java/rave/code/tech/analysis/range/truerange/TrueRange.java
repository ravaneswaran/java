package rave.code.tech.analysis.range.truerange;

public class TrueRange {

    protected double high;
    protected double low;
    protected double previousClose;

    public TrueRange(double high, double low, double previousClose) {
        this.high = high;
        this.low = low;
        this.previousClose = previousClose;
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

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getMax() {
        return Math.max(this.getHigh() - this.getLow(), Math.max(Math.abs(this.getHigh() - this.getPreviousClose()), Math.abs(this.getLow() - this.getPreviousClose())));
    }
}
