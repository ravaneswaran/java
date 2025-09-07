package rave.code.entity.nse.csv;

import javax.persistence.*;

@Entity
@Table(name = "nse_sme_detail")
@Access(AccessType.FIELD)
public class NSESMEDetailEntity  extends AbstractNSECSVEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "open_price")
    private double openPrice;
    @Column(name = "high_price")
    private double highPrice;
    @Column(name = "low_price")
    private double lowPrice;
    @Column(name = "previous_close_price")
    private double previousClosePrice;
    @Column(name = "last_traded_price")
    private double lastTradedPrice;
    @Column(name = "percentage_change")
    private double percentageChange;
    @Column(name = "volume")
    private int volume;
    @Column(name = "value_in_lakhs")
    private double valueInLakhs;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getPreviousClosePrice() {
        return previousClosePrice;
    }

    public void setPreviousClosePrice(double previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getValueInLakhs() {
        return valueInLakhs;
    }

    public void setValueInLakhs(double valueInLakhs) {
        this.valueInLakhs = valueInLakhs;
    }
}
