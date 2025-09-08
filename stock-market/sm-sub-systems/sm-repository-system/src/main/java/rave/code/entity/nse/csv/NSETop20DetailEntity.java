package rave.code.entity.nse.csv;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_top20_detail")
@Access(AccessType.FIELD)
public class NSETop20DetailEntity extends AbstractNSECSVEntity{

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "top20_type")
    private String top20Type;
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
    @Column(name = "volume_in_shares")
    private int volumeInShares;
    @Column(name = "value_in_lakhs")
    private double valueInLakhs;
    @Column(name = "ca")
    private Date CA;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public String getTop20Type() {
        return top20Type;
    }

    public void setTop20Type(String top20Type) {
        this.top20Type = top20Type;
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

    public int getVolumeInShares() {
        return volumeInShares;
    }

    public void setVolumeInShares(int volumeInShares) {
        this.volumeInShares = volumeInShares;
    }

    public double getValueInLakhs() {
        return valueInLakhs;
    }

    public void setValueInLakhs(double valueInLakhs) {
        this.valueInLakhs = valueInLakhs;
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
}
