package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.AbstractWebPage;
import rave.code.data.model.web.bse.BSEStockModel;

import java.util.List;

public class BSEWebPage extends AbstractWebPage {

    private String active100LinkStyle = "";
    private String active200LinkStyle = "";
    private String active500LinkStyle = "";
    private String priceShockersLinkStyle = "";
    private String volumeShockersLinkStyle = "";
    private String topDividendLinkStyle = "";
    private String smallCapGainerLinkStyle = "";
    private String midCapGainerLinkStyle = "";
    private String sensexLinkStyle = "";
    private List<BSEStockModel> stocks;

    public String getActive100LinkStyle() {
        return active100LinkStyle;
    }

    public void setActive100LinkStyle(String active100LinkStyle) {
        this.active100LinkStyle = active100LinkStyle;
    }

    public String getActive200LinkStyle() {
        return active200LinkStyle;
    }

    public void setActive200LinkStyle(String active200LinkStyle) {
        this.active200LinkStyle = active200LinkStyle;
    }

    public String getActive500LinkStyle() {
        return active500LinkStyle;
    }

    public void setActive500LinkStyle(String active500LinkStyle) {
        this.active500LinkStyle = active500LinkStyle;
    }

    public String getPriceShockersLinkStyle() {
        return priceShockersLinkStyle;
    }

    public void setPriceShockersLinkStyle(String priceShockersLinkStyle) {
        this.priceShockersLinkStyle = priceShockersLinkStyle;
    }

    public String getTopDividendLinkStyle() {
        return topDividendLinkStyle;
    }

    public void setTopDividendLinkStyle(String topDividendLinkStyle) {
        this.topDividendLinkStyle = topDividendLinkStyle;
    }

    public String getSmallCapGainerLinkStyle() {
        return smallCapGainerLinkStyle;
    }

    public void setSmallCapGainerLinkStyle(String smallCapGainerLinkStyle) {
        this.smallCapGainerLinkStyle = smallCapGainerLinkStyle;
    }

    public String getMidCapGainerLinkStyle() {
        return midCapGainerLinkStyle;
    }

    public void setMidCapGainerLinkStyle(String midCapGainerLinkStyle) {
        this.midCapGainerLinkStyle = midCapGainerLinkStyle;
    }

    public String getVolumeShockersLinkStyle() {
        return volumeShockersLinkStyle;
    }

    public void setVolumeShockersLinkStyle(String volumeShockersLinkStyle) {
        this.volumeShockersLinkStyle = volumeShockersLinkStyle;
    }

    public String getSensexLinkStyle() {
        return sensexLinkStyle;
    }

    public void setSensexLinkStyle(String sensexLinkStyle) {
        this.sensexLinkStyle = sensexLinkStyle;
    }

    public List<BSEStockModel> getStocks() {
        return stocks;
    }

    public void setStocks(List<BSEStockModel> stocks) {
        this.stocks = stocks;
    }


}
