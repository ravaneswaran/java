package rave.code.data.model.web.bse.stock;

public class VolumeShockerStock extends ActiveStock {

    private String sector;
    private double lastPrice;
    private double averageVolume;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public double getLastPrice() {
        return lastPrice;
    }

    @Override
    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getAverageVolume() {
        return averageVolume;
    }

    public void setAverageVolume(double averageVolume) {
        this.averageVolume = averageVolume;
    }

}
