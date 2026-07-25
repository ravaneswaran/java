package rave.code.tech.analysis.trend;

public interface Trend {

    public double getCurrentHigh();

    public void setCurrentHigh(double currentHigh);

    public double getCurrentLow() ;

    public void setCurrentLow(double currentLow);

    public double getPreviousHigh();

    public void setPreviousHigh(double previousHigh);

    public double getPreviousLow();

    public void setPreviousLow(double previousLow);

}
