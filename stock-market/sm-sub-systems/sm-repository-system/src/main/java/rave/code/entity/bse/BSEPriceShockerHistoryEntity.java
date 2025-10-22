package rave.code.entity.bse;

import javax.persistence.*;

@Embeddable
@Table(name = "bse_price_shockers_history")
@Access(AccessType.FIELD)
public class BSEPriceShockerHistoryEntity extends StockMarketShockerEntity{

    @Column(name = "current_price")
    private String previousPrice;
    @Column(name = "current_price_movement")
    private String currentPrice;
    @Column(name = "previous_price")
    private String currentPriceMovement;

    public String getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrentPriceMovement() {
        return currentPriceMovement;
    }
    public void setCurrentPriceMovement(String currentPriceMovement) {
        this.currentPriceMovement = currentPriceMovement;
    }

    public String getPreviousPrice() {return previousPrice;}
    public void setPreviousPrice(String previousPrice) {
        this.previousPrice = previousPrice;
    }
}
