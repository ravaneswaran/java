package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.AbstractWebPage;
import rave.code.data.model.web.nse.NSEStockModel;

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
}
