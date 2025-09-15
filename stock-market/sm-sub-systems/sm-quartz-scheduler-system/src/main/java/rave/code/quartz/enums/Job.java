package rave.code.quartz.enums;

public enum Job {

    BSE_ACTIVE_100_JOB_NAME("BSEActive100Job"),
    BSE_ACTIVE_200_JOB_NAME("BSEActive200Job"),
    BSE_ACTIVE_500_JOB_NAME("BSEActive500Job"),
    BSE_PRICE_SHOCKERS_JOB_NAME("BSEPriceShockersJob"),
    BSE_VOLUME_SHOCKERS_JOB_NAME("BSEVolumeShockersJob"),

    BSE_TOP_DIVIDEND_JOB_NAME("BSETopDividend"),
    BSE_MID_CAP_GAINER_JOB_NAME("BSEMidCapGainer"),
    BSE_SMALL_CAP_GAINER_JOB_NAME("BSESmallCapGainer"),

    BSE_SENSEX_JOB_NAME("BSESensexJob"),
    BSE_STOCK_BASE_JOB_NAME("BSEStockBaseJob"),

    BSE_ACTIVE_100_HISTORY_JOB_NAME("BSEActive100HistoryJob"),
    BSE_ACTIVE_200_HISTORY_JOB_NAME("BSEActive200HistoryJob"),
    BSE_ACTIVE_500_HISTORY_JOB_NAME("BSEActive500HistoryJob"),
    BSE_ACTIVE_PRICE_SHOCKER_HISTORY_JOB_NAME("BSEPriceShockerHistoryJob"),
    BSE_ACTIVE_VOLUME_SHOCKER_HISTORY_JOB_NAME("BSEVolumeShockerHistoryJob"),

    NSE_FIRST_BLOCK_DEAL_SESSION(""),
    NSE_SECOND_BLOCK_DEAL_SESSION(""),
    NSE_PRE_OPEN_REGULAR_SESSION(""),
    NSE_PRE_OPEN_SPECIAL_SESSION(""),
    NSE_T_PLUS_0_LIVE_SESSION(""),
    NSE_POST_MARKET_CLOSE("");

    private String name;

    private Job(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
