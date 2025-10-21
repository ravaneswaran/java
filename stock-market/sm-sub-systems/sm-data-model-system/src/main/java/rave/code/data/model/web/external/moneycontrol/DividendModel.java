package rave.code.data.model.web.external.moneycontrol;

import java.util.Objects;

public class DividendModel {

    private String stockName;
    private String lastPrice;
    private String latestDividendPercentage;
    private String dividendYieldPercentAt52High;
    private String dividendYieldPercentAt52Low;
    private String dividendYieldPercentAtCurrent;

    public String getStockName() {
        return this.stockName;
    }

    public void setStockName(String companyName) {
        this.stockName = companyName;
    }

    public String getLastPrice() {
        return this.lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLatestDividendPercentage() {
        return this.latestDividendPercentage;
    }

    public void setLatestDividendPercentage(String latestDividendPercentage) {
        this.latestDividendPercentage = latestDividendPercentage;
    }

    public String getDividendYieldPercentAt52High() {
        return this.dividendYieldPercentAt52High;
    }

    public void setDividendYieldPercentAt52High(String dividendYieldPercentAt52High) {
        this.dividendYieldPercentAt52High = dividendYieldPercentAt52High;
    }

    public String getDividendYieldPercentAt52Low() {
        return this.dividendYieldPercentAt52Low;
    }

    public void setDividendYieldPercentAt52Low(String dividendYieldPercentAt52Low) {
        this.dividendYieldPercentAt52Low = dividendYieldPercentAt52Low;
    }

    public String getDividendYieldPercentAtCurrent() {
        return this.dividendYieldPercentAtCurrent;
    }

    public void setDividendYieldPercentAtCurrent(String dividendYieldPercentAtCurrent) {
        this.dividendYieldPercentAtCurrent = dividendYieldPercentAtCurrent;
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
