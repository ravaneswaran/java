package rave.code.entity.nse.csv;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_price_spurt_detail")
@Access(AccessType.FIELD)
public class NSEPriceSpurtDetailEntity extends AbstractNSECSVEntity implements Comparable<NSEPriceSpurtDetailEntity> {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "spurt_type")
    private String spurtType;
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
    @Column(name = "value")
    private double value;
    @Column(name = "ca")
    private Date CA;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public String getSpurtType() {
        return spurtType;
    }

    public void setSpurtType(String spurtType) {
        this.spurtType = spurtType;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getCA() {
        return CA;
    }

    public void setCA(Date CA) {
        this.CA = CA;
    }

    public String getKey(){
        return this.getSymbol();
    }

    @Override
    public int compareTo(@NonNull NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity) {
        if (this.getLastTradedPrice() > nsePriceSpurtDetailEntity.getLastTradedPrice()) {
            return 1;
        } else if (this.getLastTradedPrice() < nsePriceSpurtDetailEntity.getLastTradedPrice()) {
            return -1;
        }
        return 0;
    }
}
