package rave.code.quartz.enums;

public enum QuartzGroup {

    TRADING_BATCH_1("Trading Batch One", "GROUP-1-Trading Batch"),
    TRADING_BATCH_2("Trading Batch Two", "GROUP-2-Trading Batch"),
    INVESTING_BATCH_1("Investing Batch One", "GROUP-1-Investing Batch"),
    INVESTING_BATCH_2("Investing Batch Two", "GROUP-2-Investing Batch"),
    MISCELLANEOUS_BATCH_1("Miscellaneous Batch One", "GROUP-1-Miscellaneous"),
    MISCELLANEOUS_BATCH_2("Miscellaneous Batch Two", "GROUP-2-Miscellaneous"),
    HISTORY("History", "GRP-History"),
    STOCK_BASE("Stock Base", "GRP-Stock Base"),

    NSE_BLOCK_DEAL_SESSION("NSE Block Deal Session", "GROUP-BLOCK-DEAL"),
    NSE_PRE_OPEN_MARKET_REGULAR_SESSION("NSE Pre Open Market Regular", "GROUP-PRE-OPEN-MARKET-REGULAR"),
    NSE_PRE_OPEN_MARKET_SPECIAL_SESSION("NSE Pre Open Market Special", "GROUP-PRE-OPEN-MARKET-SPECIAL"),
    NSE_LIVE_SESSION("NSE Live Session", "GROUP-LIVE-SESSION"),
    NSE_DAILY_TRADE_DETAILS_MAILER("NSE Daily Trade Details Mailer", "GROUP-PRE-OPEN-MAILER"),
    NSE_POST_MARKET_CLOSE("NSE Post Market Session", "GROUP-POST-MARKET-CLOSE"),
    /*NSE_POST_MARKET_CLOSE_BHAVCOPY("NSE Post Market Session Bhavcopy", "GRP-POST-MKT-CLOSE-BHAVCOPY"),
    NSE_POST_MARKET_CLOSE_PE_RATIO("NSE Post Market Session PE Ratio", "GRP-POST-MKT-CLOSE-PE-RATIO")*/;

    private String name;
    private String shortName;

    private QuartzGroup(String name){
        this.name = name;
    }

    private QuartzGroup(String name, String shortName){
        this(name);
        this.shortName = shortName;
    }

    public String get(){
        return this.getShortName();
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }
}
