package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.AbstractWebPage;
import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.data.model.web.nse.page.links.Link;

import java.util.ArrayList;
import java.util.List;

public class NSEWebPage extends AbstractWebPage {

    private boolean priceSpurt;
    private boolean volumeSpurt;
    private boolean sme;
    private boolean niftyFifty;
    private boolean niftyNextFifty;
    private boolean FOSecurity;
    private boolean securityLessThan20;
    private boolean securityGreaterThan20;
    private boolean bankNifty;
    private boolean preOpenMarketFO;
    private boolean preOpenMarketNifty50;
    private boolean preOpenMarketBankNifty;
    private boolean preOpenMarketSME;
    private boolean preOpenMarketOthers;
    private List<NSEStockModel> nseStockModels;
    protected List<Link> links;

    public NSEWebPage(){
        Link link1 = new Link("/nse-india/pre-open-market/nifty-50", "Nifty 50", "");
        Link link2 = new Link("/nse-india/pre-open-market/bank-nifty", "Bank Nifty", "");
        Link link3 = new Link("/nse-india/pre-open-market/sme", "SME", "");
        Link link4 = new Link("/nse-india/pre-open-market/fo", "FO", "");
        Link link5 = new Link("/nse-india/pre-open-market/others", "Others", "");
        Link link6 = new Link("/nse-india/price-spurts", "Price Spurts", "");
        Link link7 = new Link("/nse-india/volume-spurts", "Volume Spurts", "");
        Link link8 = new Link("/nse-india/sme", "SME", "");
        Link link9 = new Link("/nse-india/top-20/security-lwr-20", "Security < 20", "");
        Link link10 = new Link("/nse-india/top-20/security-gtr-20", "Security > 20", "");
        Link link11 = new Link("/nse-india/top-20/nifty-fifty", "Nifty Fifty", "");
        Link link12 = new Link("/nse-india/top-20/nifty-next-fifty", "Nifty Next Fifty", "");
        Link link13 = new Link("/nse-india/top-20/fo-security", "FO Security", "");
        Link link14 = new Link("/nse-india/top-20/bank-nifty", "Bank Nifty", "");


        this.links = new ArrayList<>();
        this.links.add(link1);
        this.links.add(link2);
        this.links.add(link3);
        this.links.add(link4);
        this.links.add(link5);
        this.links.add(link6);
        this.links.add(link7);
        this.links.add(link8);
        this.links.add(link9);
        this.links.add(link10);
        this.links.add(link11);
        this.links.add(link12);
        this.links.add(link13);
        this.links.add(link14);
    }

    public boolean isPreOpenMarketOthers() {
        return preOpenMarketOthers;
    }

    public void setPreOpenMarketOthers(boolean preOpenMarketOthers) {
        this.preOpenMarketOthers = preOpenMarketOthers;
    }

    public boolean isPreOpenMarketSME() {
        return preOpenMarketSME;
    }

    public void setPreOpenMarketSME(boolean preOpenMarketSME) {
        this.preOpenMarketSME = preOpenMarketSME;
    }

    public boolean isPreOpenMarketBankNifty() {
        return preOpenMarketBankNifty;
    }

    public void setPreOpenMarketBankNifty(boolean preOpenMarketBankNifty) {
        this.preOpenMarketBankNifty = preOpenMarketBankNifty;
    }

    public boolean isPreOpenMarketNifty50() {
        return preOpenMarketNifty50;
    }

    public void setPreOpenMarketNifty50(boolean preOpenMarketNifty50) {
        this.preOpenMarketNifty50 = preOpenMarketNifty50;
    }

    public boolean isPreOpenMarketFO() {
        return preOpenMarketFO;
    }

    public void setPreOpenMarketFO(boolean preOpenMarketFO) {
        this.preOpenMarketFO = preOpenMarketFO;
    }

    public boolean isPriceSpurt() {
        return priceSpurt;
    }

    public void setPriceSpurt(boolean priceSpurt) {
        this.priceSpurt = priceSpurt;
    }

    public boolean isVolumeSpurt() {
        return volumeSpurt;
    }

    public void setVolumeSpurt(boolean volumeSpurt) {
        this.volumeSpurt = volumeSpurt;
    }

    public boolean isSme() {
        return sme;
    }

    public void setSme(boolean sme) {
        this.sme = sme;
    }

    public boolean isNiftyFifty() {
        return niftyFifty;
    }

    public void setNiftyFifty(boolean niftyFifty) {
        this.niftyFifty = niftyFifty;
    }

    public boolean isNiftyNextFifty() {
        return niftyNextFifty;
    }

    public void setNiftyNextFifty(boolean niftyNextFifty) {
        this.niftyNextFifty = niftyNextFifty;
    }

    public boolean isFOSecurity() {
        return FOSecurity;
    }

    public void setFOSecurity(boolean FOSecurity) {
        this.FOSecurity = FOSecurity;
    }

    public boolean isSecurityLessThan20() {
        return securityLessThan20;
    }

    public void setSecurityLessThan20(boolean securityLessThan20) {
        this.securityLessThan20 = securityLessThan20;
    }

    public boolean isSecurityGreaterThan20() {
        return securityGreaterThan20;
    }

    public void setSecurityGreaterThan20(boolean securityGreaterThan20) {
        this.securityGreaterThan20 = securityGreaterThan20;
    }

    public boolean isBankNifty() {
        return bankNifty;
    }

    public void setBankNifty(boolean bankNifty) {
        this.bankNifty = bankNifty;
    }

    public List<NSEStockModel> getNseStockModels() {
        return nseStockModels;
    }

    public void setNseStockModels(List<NSEStockModel> nseStockModels) {
        this.nseStockModels = nseStockModels;
    }

    public List<Link> getLinks() {
        return links;
    }


    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
