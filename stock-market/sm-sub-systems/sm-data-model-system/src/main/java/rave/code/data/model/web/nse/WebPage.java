package rave.code.data.model.web.nse;

public class WebPage {

    private boolean priceSpurt;
    private boolean volumeSpurt;
    private boolean sme;
    private boolean niftyFifty;
    private boolean niftyNextFifty;
    private boolean FOSecurity;
    private boolean securityLessThan20;
    private boolean securityGreaterThan20;
    private boolean bankNifty;

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
}
