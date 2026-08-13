package rave.code.entity.nse.histories;

import rave.code.entity.nse.csv.AbstractNSECSVEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "nse_pre_open_market_detail_history")
@Access(AccessType.FIELD)
public class NSEPreOpenMarketDetailHistoryEntity extends AbstractNSECSVEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "business_date")
    private Date businessDate;
    @Column(name = "pre_open_type")
    private String preOpenType;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "previous_close")
    private double previousClose;
    @Column(name = "indicative_equilibrium_price_of_first_instance")
    private double indicativeEquilibriumPriceOfFirstInstance;
    @Column(name = "price_change_of_first_instance")
    private double priceChangeOfFirstInstance;
    @Column(name = "price_percentage_change_of_first_instance")
    private double pricePercentageChangeOfFirstInstance;
    @Column(name = "indicative_equilibrium_price_of_last_instance")
    private double indicativeEquilibriumPriceOfLastInstance;
    @Column(name = "price_change_of_last_instance")
    private double priceChangeOfLastInstance;
    @Column(name = "price_percentage_change_of_last_instance")
    private double pricePercentageChangeOfLastInstance;
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

    public String getPreOpenType() {
        return preOpenType;
    }

    public void setPreOpenType(String preOpenType) {
        this.preOpenType = preOpenType;
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

    public double getIndicativeEquilibriumPriceOfFirstInstance() {
        return indicativeEquilibriumPriceOfFirstInstance;
    }

    public void setIndicativeEquilibriumPriceOfFirstInstance(double indicativeEquilibriumPriceOfFirstInstance) {
        this.indicativeEquilibriumPriceOfFirstInstance = indicativeEquilibriumPriceOfFirstInstance;
    }

    public double getPriceChangeOfFirstInstance() {
        return priceChangeOfFirstInstance;
    }

    public void setPriceChangeOfFirstInstance(double priceChangeOfFirstInstance) {
        this.priceChangeOfFirstInstance = priceChangeOfFirstInstance;
    }

    public double getPricePercentageChangeOfFirstInstance() {
        return pricePercentageChangeOfFirstInstance;
    }

    public void setPricePercentageChangeOfFirstInstance(double pricePercentageChangeOfFirstInstance) {
        this.pricePercentageChangeOfFirstInstance = pricePercentageChangeOfFirstInstance;
    }

    public double getIndicativeEquilibriumPriceOfLastInstance() {
        return indicativeEquilibriumPriceOfLastInstance;
    }

    public void setIndicativeEquilibriumPriceOfLastInstance(double indicativeEquilibriumPriceOfLastInstance) {
        this.indicativeEquilibriumPriceOfLastInstance = indicativeEquilibriumPriceOfLastInstance;
    }

    public double getPriceChangeOfLastInstance() {
        return priceChangeOfLastInstance;
    }

    public void setPriceChangeOfLastInstance(double priceChangeOfLastInstance) {
        this.priceChangeOfLastInstance = priceChangeOfLastInstance;
    }

    public double getPricePercentageChangeOfLastInstance() {
        return pricePercentageChangeOfLastInstance;
    }

    public void setPricePercentageChangeOfLastInstance(double pricePercentageChangeOfLastInstance) {
        this.pricePercentageChangeOfLastInstance = pricePercentageChangeOfLastInstance;
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
}
