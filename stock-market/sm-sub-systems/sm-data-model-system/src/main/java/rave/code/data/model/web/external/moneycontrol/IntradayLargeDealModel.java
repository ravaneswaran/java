package rave.code.data.model.web.external.moneycontrol;

public class IntradayLargeDealModel {

    private String stockName;
    private String sector;
    private String quantity;
    private String tradedPrice;
    private String dealValueInCrores;
    private String exchange;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTradedPrice() {
        return tradedPrice;
    }

    public void setTradedPrice(String tradedPrice) {
        this.tradedPrice = tradedPrice;
    }

    public String getDealValueInCrores() {
        return dealValueInCrores;
    }

    public void setDealValueInCrores(String dealValueInCrores) {
        this.dealValueInCrores = dealValueInCrores;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
