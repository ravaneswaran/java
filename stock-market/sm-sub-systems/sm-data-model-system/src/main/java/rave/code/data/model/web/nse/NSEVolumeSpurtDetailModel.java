package rave.code.data.model.web.nse;

public class NSEVolumeSpurtDetailModel extends NSEStockModel {

    private int volume;
    private int oneWeekAverageVolume;
    private double noOfTimes;

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
