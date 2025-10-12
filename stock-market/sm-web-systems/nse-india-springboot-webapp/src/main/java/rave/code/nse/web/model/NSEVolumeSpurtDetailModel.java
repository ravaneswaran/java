package rave.code.nse.web.model;

public class NSEVolumeSpurtDetailModel {

    private String symbol;
    private int volume;
    private int oneWeekAverageVolume;
    private double noOfTimes;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getOneWeekAverageVolume() {
        return oneWeekAverageVolume;
    }

    public void setOneWeekAverageVolume(int oneWeekAverageVolume) {
        this.oneWeekAverageVolume = oneWeekAverageVolume;
    }

    public double getNoOfTimes() {
        return noOfTimes;
    }

    public void setNoOfTimes(double noOfTimes) {
        this.noOfTimes = noOfTimes;
    }
}
