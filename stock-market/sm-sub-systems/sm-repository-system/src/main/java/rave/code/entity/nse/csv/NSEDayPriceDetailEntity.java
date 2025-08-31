package rave.code.entity.nse.csv;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_day_price_detail")
@Access(AccessType.FIELD)
public class NSEDayPriceDetailEntity extends AbstractNSECSVEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "business_date")
    private Date businessDate;
    @Column(name = "mkt")
    private String mkt;
    @Column(name = "series")
    private String series;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "previous_close_price")
    private String previousClosePrice;
    @Column(name = "open_price")
    private String openPrice;
    @Column(name = "high_price")
    private String highPrice;
    @Column(name = "low_price")
    private String lowPrice;
    @Column(name = "close_price")
    private String closePrice;
    @Column(name = "net_traded_value")
    private String netTradedValue;
    @Column(name = "net_traded_quantity")
    private String netTradedQuantity;
    @Column(name = "index_or_security")
    private String indexOrSecurity;
    @Column(name = "corp_index")
    private String corpIndex;
    @Column(name = "trades")
    private String trades;
    @Column(name = "high_52_week")
    private String high52Week;
    @Column(name = "low_52_week")
    private String low52Week;

    public NSEStockBaseEntity getNseStockBaseEntity() {return nseStockBaseEntity;}
    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {this.nseStockBaseEntity = nseStockBaseEntity;}

    public Date getBusinessDate() {return businessDate;}
    public void setBusinessDate(Date businessDate) {this.businessDate = businessDate;}

    public String getMkt() {
        return mkt;
    }
    public void setMkt(String mkt) {
        this.mkt = mkt;
    }

    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }

    public String getSymbol() {return symbol;}
    public void setSymbol(String symbol) {this.symbol = symbol;}

    public String getCompanyName() {return companyName;}
    public void setCompanyName(String companyName) {this.companyName = companyName;}

    public String getOpenPrice() {
        return openPrice;
    }
    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getHighPrice() {return highPrice;}
    public void setHighPrice(String highPrice) {this.highPrice = highPrice;}

    public String getLowPrice() {
        return lowPrice;
    }
    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }
    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getPreviousClosePrice() {
        return previousClosePrice;
    }
    public void setPreviousClosePrice(String previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public String getNetTradedValue() {
        return netTradedValue;
    }
    public void setNetTradedValue(String netTradedValue) {
        this.netTradedValue = netTradedValue;
    }

    public String getNetTradedQuantity() {
        return netTradedQuantity;
    }
    public void setNetTradedQuantity(String netTradedQuantity) {
        this.netTradedQuantity = netTradedQuantity;
    }

    public String getIndexOrSecurity() {
        return indexOrSecurity;
    }
    public void setIndexOrSecurity(String indexOrSecurity) {
        this.indexOrSecurity = indexOrSecurity;
    }

    public String getCorpIndex() {
        return corpIndex;
    }
    public void setCorpIndex(String corpIndex) {
        this.corpIndex = corpIndex;
    }

    public String getTrades() {
        return trades;
    }
    public void setTrades(String trades) {
        this.trades = trades;
    }

    public String getHigh52Week() {return high52Week;}
    public void setHigh52Week(String high52Week) {this.high52Week = high52Week;}

    public String getLow52Week() {
        return low52Week;
    }
    public void setLow52Week(String low52Week) {
        this.low52Week = low52Week;
    }

    public String getKey(){
        return String.format("%s:%s:%s", this.getSymbol(), this.getCompanyName(), this.getSeries());
    }

}
