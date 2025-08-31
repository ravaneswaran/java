package rave.code.quartz.enums;

public enum DailyPriceListDownloadLink {

    DAILY_PRICE_LIST_DOWNLOAD_LINK_BSE("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_%s_F_0000.CSV"),
    DAILY_PRICE_LIST_DOWNLOAD_LINK_NSE("https://nsearchives.nseindia.com/archives/equities/bhavcopy/pr/PR%s.zip");

    private String link;

    private DailyPriceListDownloadLink(String link) {
        this.link = link;
    }

    public String get() {
        return this.link;
    }
}