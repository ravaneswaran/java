package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.AbstractWebPage;

public class BSEWebPage extends AbstractWebPage {

    private boolean active100Link;
    private boolean active200Link;
    private boolean active500Link;
    private boolean priceShockersLink;
    private boolean volumeShockersLink;
    private boolean topDividendLink;
    private boolean smallCapGainerLink;
    private boolean midCapGainerLink;
    private boolean sensexLink;

    private String active100LinkStyle = "";
    private String active200LinkStyle = "";
    private String active500LinkStyle = "";
    private String priceShockersLinkStyle = "";
    private String volumeShockersLinkStyle = "";
    private String topDividendLinkStyle = "";
    private String smallCapGainerLinkStyle = "";
    private String midCapGainerLinkStyle = "";
    private String sensexLinkStyle = "";

    public boolean isSensexLink() {
        return sensexLink;
    }

    public void setSensexLink(boolean sensexLink) {
        this.sensexLink = sensexLink;
    }

    public boolean isActive100Link() {
        return active100Link;
    }

    public void setActive100Link(boolean active100Link) {
        this.active100Link = active100Link;
    }

    public boolean isActive200Link() {
        return active200Link;
    }

    public void setActive200Link(boolean active200Link) {
        this.active200Link = active200Link;
    }

    public boolean isActive500Link() {
        return active500Link;
    }

    public void setActive500Link(boolean active500Link) {
        this.active500Link = active500Link;
    }

    public boolean isPriceShockersLink() {
        return priceShockersLink;
    }

    public void setPriceShockersLink(boolean priceShockersLink) {
        this.priceShockersLink = priceShockersLink;
    }

    public boolean isVolumeShockersLink() {
        return volumeShockersLink;
    }

    public void setVolumeShockersLink(boolean volumeShockersLink) {
        this.volumeShockersLink = volumeShockersLink;
    }

    public boolean isTopDividendLink() {
        return topDividendLink;
    }

    public void setTopDividendLink(boolean topDividendLink) {
        this.topDividendLink = topDividendLink;
    }

    public boolean isSmallCapGainerLink() {
        return smallCapGainerLink;
    }

    public void setSmallCapGainerLink(boolean smallCapGainerLink) {
        this.smallCapGainerLink = smallCapGainerLink;
    }

    public boolean isMidCapGainerLink() {
        return midCapGainerLink;
    }

    public void setMidCapGainerLink(boolean midCapGainerLink) {
        this.midCapGainerLink = midCapGainerLink;
    }

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

}
