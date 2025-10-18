package rave.code.quartz.enums;

public enum QuartzGroup {

    TRADING_BATCH_1("Trading Batch One", "GRP-1-Trading Batch"),
    TRADING_BATCH_2("Trading Batch Two", "GRP-2-Trading Batch"),
    INVESTING_BATCH_1("Investing Batch One", "GRP-1-Investing Batch"),
    INVESTING_BATCH_2("Investing Batch Two", "GRP-2-Investing Batch"),
    MISCELLANEOUS_BATCH_1("Miscellaneous Batch One", "GRP-1-Miscellaneous"),
    MISCELLANEOUS_BATCH_2("Miscellaneous Batch Two", "GRP-2-Miscellaneous"),
    HISTORY("History", "GRP-History"),
    STOCK_BASE("Stock Base", "GRP-Stock Base"),

    NSE_BLOCK_DEAL_SESSION("NSE Block Deal Session", "GRP-Block Deal"),
    NSE_PRE_OPEN_MARKET_REGULAR_SESSION("NSE Pre Open Market Regular", "GRP-Pre Open Reg"),
    NSE_PRE_OPEN_MARKET_SPECIAL_SESSION("NSE Pre Open Market Special", "GRP-Pre Open Spl"),
    NSE_LIVE_SESSION("NSE Live Session", "Grp-Live Session"),
    NSE_POST_MARKET_CLOSE("NSE Post Market Session", "GRP-Post Mkt Close");

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
