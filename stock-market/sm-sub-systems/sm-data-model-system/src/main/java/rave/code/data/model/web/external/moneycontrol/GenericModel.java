package rave.code.data.model.web.external.moneycontrol;

import java.util.Objects;

public class GenericModel {

    protected String stockName;
    protected String high;
    protected String low;
    protected String lastPrice;
    private String previousClose;
    private String change;
    private String percentageGain;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getPercentageGain() {
        return percentageGain;
    }

    public void setPercentageGain(String percentageGain) {
        this.percentageGain = percentageGain;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        GenericModel that = (GenericModel) obj;
        return this.stockName.equals(that.getStockName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.stockName);
    }
}
