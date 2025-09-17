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


    NSE_PRE_OPEN_SPECIAL_SESSION(""),
    NSE_T_PLUS_0_LIVE_SESSION("NSE T+0 Live Session"),

    NSE_FIRST_BLOCK_DEAL_SESSION_JOB("NSE First Block Deal Session"),
    NSE_SECOND_BLOCK_DEAL_SESSION("NSE Second Block Deal Session"),

    NSE_PRE_OPEN_MARKET_NIFTY_50_REGULAR_SESSION_JOB("NSE Pre Open Market Nifty 50 Regular Session"),
    NSE_PRE_OPEN_MARKET_BANK_NIFTY_REGULAR_SESSION_JOB("NSE Pre Open Market Bank Nifty Regular Session"),
    NSE_PRE_OPEN_MARKET_SME_REGULAR_SESSION_JOB("NSE Pre Open Market SME Regular Session"),
    NSE_PRE_OPEN_MARKET_FO_REGULAR_SESSION_JOB("NSE Pre Open Market FO Regular Session"),
    NSE_PRE_OPEN_MARKET_OTHERS_REGULAR_SESSION_JOB("NSE Pre Open Market Others Regular Session"),

    NSE_T_PLUS_0_ETF_LIVE_SESSION("NSE ETF T+0 Live Session"),
    NSE_T_PLUS_0_MAIN_BOARD_LIVE_SESSION("NSE Main Board T+0 Live Session"),
    NSE_T_PLUS_0_SME_LIVE_SESSION("NSE SME T+0 Live Session"),
    NSE_T_PLUS_0_PRICE_SPURT_SP_GTR_20_LIVE_SESSION("NSE Price Spurt SP > 20 T+0 Live Session"),
    NSE_T_PLUS_0_PRICE_SPURT_SP_LWR_20_LIVE_SESSION("NSE Price Spurt SP < 20 T+0 Live Session"),
    NSE_T_PLUS_0_VOLUME_SPURT_LIVE_SESSION("NSE Volume Spurt T+0 Live Session"),

    NSE_T_PLUS_0_BANK_NIFTY_GAINER_TOP_20_LIVE_SESSION("NSE Bank Nifty Gainer Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_FO_GAINER_TOP_20_LIVE_SESSION("NSE FO Gainer Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_NIFTY_50_GAINER_TOP_20_LIVE_SESSION("NSE Nifty 50 Gainer Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_NIFTY_NEXT_50_GAINER_TOP_20_LIVE_SESSION("NSE Nifty Next 50 Gainer Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_SECURITY_GTR_20_GAINER_TOP_20_LIVE_SESSION("NSE SP > 20 Gainer Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_SECURITY_LWR_20_GAINER_TOP_20_LIVE_SESSION("NSE SP < 20 Gainer Top-20 T+0 Live Session"),

    NSE_T_PLUS_0_BANK_NIFTY_LOSER_TOP_20_LIVE_SESSION("NSE Bank Nifty Loser Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_FO_LOSER_TOP_20_LIVE_SESSION("NSE FO Loser Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_NIFTY_50_LOSER_TOP_20_LIVE_SESSION("NSE Nifty 50 Loser Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_NIFTY_NEXT_50_LOSER_TOP_20_LIVE_SESSION("NSE Nifty Next 50 Loser Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_SECURITY_GTR_20_LOSER_TOP_20_LIVE_SESSION("NSE SP > 20 Loser Top-20 T+0 Live Session"),
    NSE_T_PLUS_0_SECURITY_LWR_20_LOSER_TOP_20_LIVE_SESSION("NSE SP < 20 Loser Top-20 T+0 Live Session"),

    NSE_POST_MARKET_CLOSE_JOB("NSE Post Market Close");

    private String name;

    private Job(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
