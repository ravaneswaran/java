package rave.code.stockmarket.entity;

import rave.code.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "stock_base_10")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "source", discriminatorType = DiscriminatorType.STRING)
@Access(AccessType.PROPERTY)
public class StockBase10Entity extends AbstractEntity {

    private String id;
    private String financialInstrumentId;
    private String financialInstrumentType;
    private String mkt;
    private String series;
    private String stockSymbol;
    private String stockName;
    private String openPrice;
    private String highPrice;
    private String lowPrice;
    private String closePrice;
    private String previousClosePrice;
    private String netTradedValue;
    private String netTradedQuantity;
    private String indexOrSecurity;
    private String corpIndex;
    private String trades;
    private String high52Week;
    private String low52Week;
    private String ISIN;
    private String dailyClosePrice;

    public StockBase10Entity(){
        this.setNewEntity(true);
    }

    @Id
    @Column(name = "id")
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    @Column(name = "financial_instrument_id")
    public String getFinancialInstrumentId() {return financialInstrumentId;}
    public void setFinancialInstrumentId(String financialInstrumentId) {this.financialInstrumentId = financialInstrumentId;}

    @Column(name = "financial_instrument_type")
    public String getFinancialInstrumentType() {return financialInstrumentType;}
    public void setFinancialInstrumentType(String financialInstrumentType) {this.financialInstrumentType = financialInstrumentType;}

    @Column(name = "mkt")
    public String getMkt() {
        return mkt;
    }
    public void setMkt(String mkt) {
        this.mkt = mkt;
    }

    @Column(name = "series")
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }

    @Column(name = "stock_symbol")
    public String getStockSymbol() {
        return stockSymbol;
    }
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Column(name = "stock_name")
    public String getStockName() {return stockName;}
    public void setStockName(String stockName) {this.stockName = stockName;}

    @Column(name = "open_price")
    public String getOpenPrice() {
        return openPrice;
    }
    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    @Column(name = "high_price")
    public String getHighPrice() {return highPrice;}
    public void setHighPrice(String highPrice) {this.highPrice = highPrice;}

    @Column(name = "low_price")
    public String getLowPrice() {
        return lowPrice;
    }
    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    @Column(name = "close_price")
    public String getClosePrice() {
        return closePrice;
    }
    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    @Column(name = "previous_close_price")
    public String getPreviousClosePrice() {
        return previousClosePrice;
    }
    public void setPreviousClosePrice(String previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    @Column(name = "net_traded_value")
    public String getNetTradedValue() {
        return netTradedValue;
    }
    public void setNetTradedValue(String netTradedValue) {
        this.netTradedValue = netTradedValue;
    }

    @Column(name = "net_traded_quantity")
    public String getNetTradedQuantity() {
        return netTradedQuantity;
    }
    public void setNetTradedQuantity(String netTradedQuantity) {
        this.netTradedQuantity = netTradedQuantity;
    }

    @Column(name = "index_or_security")
    public String getIndexOrSecurity() {
        return indexOrSecurity;
    }
    public void setIndexOrSecurity(String indexOrSecurity) {
        this.indexOrSecurity = indexOrSecurity;
    }

    @Column(name = "corp_index")
    public String getCorpIndex() {
        return corpIndex;
    }
    public void setCorpIndex(String corpIndex) {
        this.corpIndex = corpIndex;
    }

    @Column(name = "trades")
    public String getTrades() {
        return trades;
    }
    public void setTrades(String trades) {
        this.trades = trades;
    }

    @Column(name = "high_52_week")
    public String getHigh52Week() {
        return high52Week;
    }
    public void setHigh52Week(String high52Week) {
        this.high52Week = high52Week;
    }

    @Column(name = "low_52_week")
    public String getLow52Week() {
        return low52Week;
    }
    public void setLow52Week(String low52Week) {
        this.low52Week = low52Week;
    }

    @Column(name = "ISIN")
    public String getISIN() {return ISIN;}
    public void setISIN(String ISIN) {this.ISIN = ISIN;}

    @Column(name = "daily_close_price")
    public String getDailyClosePrice() {
        return dailyClosePrice;
    }
    public void setDailyClosePrice(String dailyClosePrice) {
        this.dailyClosePrice = dailyClosePrice;
    }

}
