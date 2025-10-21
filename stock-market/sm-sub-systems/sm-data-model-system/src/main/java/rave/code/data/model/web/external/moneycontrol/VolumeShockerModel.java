package rave.code.data.model.web.external.moneycontrol;

public class VolumeShockerModel extends BSEGenericActiveModel {

    private String sector;
    private String lastPrice;
    private String averageVolume;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String getLastPrice() {
        return lastPrice;
    }

    @Override
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getAverageVolume() {
        return averageVolume;
    }

    public void setAverageVolume(String averageVolume) {
        this.averageVolume = averageVolume;
    }
}
