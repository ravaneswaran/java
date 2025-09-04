package rave.code.entity.nse.csv;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "nse_pre_open_market_detail")
@Access(AccessType.FIELD)
public class NSEPreOpenMarketDetailEntity extends AbstractNSECSVEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "business_date")
    protected Date businessDate;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "previous_close")
    private double previousClose;
    @Column(name = "indicative_equilibrium_price")
    private double indicativeEquilibriumPrice;
    @Column(name = "price_change")
    private double priceChange;
    @Column(name = "price_percentage_change")
    private double pricePercentageChange;
    @Column(name = "final_price")
    private double finalPrice;
    @Column(name = "final_quantity")
    private int finalQuantity;
    @Column(name = "value_in_crores")
    private BigDecimal valueInCrores;
    @Column(name = "free_float_market_capitalization")
    private BigDecimal freeFloatMarketCapitalization;
    @Column(name = "new_market_52_week_high")
    private double newMarket52WeekHigh;
    @Column(name = "new_market_52_week_low")
    private double newMarket52WeekLow;

    public NSEPreOpenMarketDetailEntity(){
        this.setBusinessDate(new Date());
    }

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getIndicativeEquilibriumPrice() {
        return indicativeEquilibriumPrice;
    }

    public void setIndicativeEquilibriumPrice(double indicativeEquilibriumPrice) {
        this.indicativeEquilibriumPrice = indicativeEquilibriumPrice;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    public double getPricePercentageChange() {
        return pricePercentageChange;
    }

    public void setPricePercentageChange(double pricePercentageChange) {
        this.pricePercentageChange = pricePercentageChange;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(int finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    public BigDecimal getValueInCrores() {
        return valueInCrores;
    }

    public void setValueInCrores(BigDecimal valueInCrores) {
        this.valueInCrores = valueInCrores;
    }

    public BigDecimal getFreeFloatMarketCapitalization() {
        return freeFloatMarketCapitalization;
    }

    public void setFreeFloatMarketCapitalization(BigDecimal freeFloatMarketCapitalization) {
        this.freeFloatMarketCapitalization = freeFloatMarketCapitalization;
    }

    public double getNewMarket52WeekHigh() {
        return newMarket52WeekHigh;
    }

    public void setNewMarket52WeekHigh(double newMarket52WeekHigh) {
        this.newMarket52WeekHigh = newMarket52WeekHigh;
    }

    public double getNewMarket52WeekLow() {
        return newMarket52WeekLow;
    }

    public void setNewMarket52WeekLow(double newMarket52WeekLow) {
        this.newMarket52WeekLow = newMarket52WeekLow;
    }

    public String getKey(){
        return this.getSymbol();
    }
}
