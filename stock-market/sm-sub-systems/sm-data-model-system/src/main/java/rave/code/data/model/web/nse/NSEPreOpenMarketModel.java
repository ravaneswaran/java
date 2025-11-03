package rave.code.data.model.web.nse;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NSEPreOpenMarketModel extends NSEStockModel{

    private Date businessDate;
    private String preOpenType;
    private String symbol;
    private double previousClose;
    private double indicativeEquilibriumPrice;
    private double priceChange;
    private double pricePercentageChange;
    private double finalPrice;
    private int finalQuantity;
    private BigDecimal valueInCrores;
    private BigDecimal freeFloatMarketCapitalization;
    private double newMarket52WeekHigh;
    private double newMarket52WeekLow;

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getBusinessDateAsString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(this.getBusinessDate());
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
}
