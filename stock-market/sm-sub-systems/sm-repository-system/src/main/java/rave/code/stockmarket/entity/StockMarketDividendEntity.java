package rave.code.stockmarket.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class StockMarketDividendEntity extends StockMarketEntity {

    @Column(name = "last_price")
    protected String lastPrice;
    @Column(name = "latest_dividend_percentage")
    protected String latestDividendPercentage;
    @Column(name = "dividend_yield_percentage_52_high")
    protected String dividendYieldPercentage52High;
    @Column(name = "dividend_yield_percentage_52_low")
    protected String dividendYieldPercentage52Low;
    @Column(name = "dividend_yield_percentage_at_current")
    protected String dividendYieldPercentageAtCurrent;

    public String getLastPrice() {return lastPrice;}
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLatestDividendPercentage() {
        return latestDividendPercentage;
    }
    public void setLatestDividendPercentage(String latestDividendPercentage) {
        this.latestDividendPercentage = latestDividendPercentage;
    }

    public String getDividendYieldPercentage52High() {
        return dividendYieldPercentage52High;
    }
    public void setDividendYieldPercentage52High(String dividendYieldPercentage52High) {
        this.dividendYieldPercentage52High = dividendYieldPercentage52High;
    }

    public String getDividendYieldPercentage52Low() {
        return dividendYieldPercentage52Low;
    }
    public void setDividendYieldPercentage52Low(String dividendYieldPercentage52Low) {
        this.dividendYieldPercentage52Low = dividendYieldPercentage52Low;
    }

    public String getDividendYieldPercentageAtCurrent() {
        return dividendYieldPercentageAtCurrent;
    }
    public void setDividendYieldPercentageAtCurrent(String dividendYieldPercentageAtCurrent) {
        this.dividendYieldPercentageAtCurrent = dividendYieldPercentageAtCurrent;
    }
}
