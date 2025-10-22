package rave.code.entity.bse;

import javax.persistence.*;

@Embeddable
@Table(name = "bse_volume_shockers_history")
@Access(AccessType.PROPERTY)
public class BSEVolumeShockerHistoryEntity extends StockMarketShockerEntity{

    private String lastPrice;
    private String lastPriceMovement;
    private String averageVolume;

    @Column(name = "average_volume")
    public String getAverageVolume() {
        return averageVolume;
    }
    public void setAverageVolume(String averageVolume) {
        this.averageVolume = averageVolume;
    }

    @Column(name = "last_price")
    public String getLastPrice() {return lastPrice;}
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    @Column(name = "last_price_movement")
    public String getLastPriceMovement() {return lastPriceMovement;}
    public void setLastPriceMovement(String lastPriceMovement) {
        this.lastPriceMovement = lastPriceMovement;
    }

}
