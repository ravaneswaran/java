package rave.code.tech.analysis.trend;

public class AbstractTrend implements Trend {

    private double currentHigh;
    private double currentLow;
    private double previousHigh;
    private double previousLow;

    public AbstractTrend(double currentHigh, double currentLow, double previousHigh, double previousLow){
        this.currentHigh = currentHigh;
        this.currentLow = currentLow;
        this.previousHigh = previousHigh;
        this.previousLow = previousLow;
    }

    @Override
    public double getCurrentHigh() {
        return currentHigh;
    }

    @Override
    public void setCurrentHigh(double currentHigh) {
        this.currentHigh = currentHigh;
    }

    @Override
    public double getCurrentLow() {
        return currentLow;
    }

    @Override
    public void setCurrentLow(double currentLow) {
        this.currentLow = currentLow;
    }

    @Override
    public double getPreviousHigh() {
        return previousHigh;
    }

    @Override
    public void setPreviousHigh(double previousHigh) {
        this.previousHigh = previousHigh;
    }

    @Override
    public double getPreviousLow() {
        return previousLow;
    }

    @Override
    public void setPreviousLow(double previousLow) {
        this.previousLow = previousLow;
    }
}
