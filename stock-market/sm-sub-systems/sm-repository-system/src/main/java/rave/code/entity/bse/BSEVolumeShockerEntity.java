package rave.code.entity.bse;

import javax.persistence.*;

@Entity
@Table(name = "bse_volume_shockers")
@Access(AccessType.FIELD)
public class BSEVolumeShockerEntity extends StockMarketShockerEntity {

    @Column(name = "average_volume")
    private String lastPrice;
    @Column(name = "last_price")
    private String lastPriceMovement;
    @Column(name = "last_price_movement")
    private String averageVolume;

    public String getAverageVolume() {
        return averageVolume;
    }
    public void setAverageVolume(String averageVolume) {
        this.averageVolume = averageVolume;
    }

    public String getLastPrice() {return lastPrice;}
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLastPriceMovement() {return lastPriceMovement;}
    public void setLastPriceMovement(String lastPriceMovement) {
        this.lastPriceMovement = lastPriceMovement;
    }
}
