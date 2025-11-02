package rave.code.quartz.enums;

public enum TriggerDescription {

    BSE_ACTIVE_100("BSE Active 100 trigger..."),
    BSE_ACTIVE_200("BSE Active 200 trigger..."),
    BSE_ACTIVE_500("BSE Active 500 trigger..."),
    BSE_PRICE_SHOCKER("BSE Price Shocker trigger..."),
    BSE_VOLUME_SHOCKER("BSE Volume Shocker trigger..."),
    BSE_TOP_DIVIDEND("BSE Top Dividend trigger..."),
    BSE_MID_CAP_GAINER("BSE Mid Cap Gainer trigger..."),
    BSE_SMALL_CAP_GAINER("BSE Small Cap Gainer trigger..."),
    SENSEX("Sensex Trigger..."),
    STOCK_BASE("Stock Base Trigger"),
    BSE_ACTIVE_100_HISTORY("Triggers the job that moves BSE Active 100 entries to the history table..."),
    BSE_ACTIVE_200_HISTORY("Triggers the job that moves BSE Active 200 entries to the history table..."),
    BSE_ACTIVE_500_HISTORY("Triggers the job that moves BSE Active 500 entries to the history table..."),
    BSE_PRICE_SHOCKER_HISTORY("Triggers the job that moves BSE Price Shocker entries to the history table..."),
    BSE_VOLUME_SHOCKER_HISTORY("Triggers the job that moves BSE Volume Shocker entries to the history table..."),


    NSE_POST_MARKET_CLOSE("Triggers the job at 04:30 PM."),
    NSE_PRE_OPEN_MARKET_REGULAR_SESSION("Triggers the job between 09:00 AM - 09:08 AM with 1 min frequency."),
    NSE_FIRST_BLOCK_DEAL_SESSION("Triggers the job between 08:45 AM - 08:59 AM with 1 min frequency."),
    NSE_SECOND_BLOCK_DEAL_SESSION("Triggers the job between 02:05 PM - 02-20 PM with 1 min frequency."),
    NSE_T_PLUS_0_SLOT_1_LIVE_SESSION("Triggers the job between 09:15 AM - 09-59 AM with 1 min frequency."),
    NSE_T_PLUS_0_SLOT_2_LIVE_SESSION("Triggers the job between 10:00 AM - 12:59 PM with 1 min frequency."),
    NSE_T_PLUS_0_SLOT_3_LIVE_SESSION("Triggers the job between 01:00 PM - 01:30 PM with 1 min frequency.");

    private String description;

    private TriggerDescription(String description){
        this.description = description;
    }

    public String get(){
        return this.description;
    }
}
