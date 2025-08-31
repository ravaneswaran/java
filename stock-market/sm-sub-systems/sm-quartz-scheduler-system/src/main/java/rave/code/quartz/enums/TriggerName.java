package rave.code.quartz.enums;

public enum TriggerName {

    BSE_ACTIVE_100_TRIGGER_NAME("BSEActive100Trigger"),
    BSE_ACTIVE_200_TRIGGER_NAME("BSEActive200Trigger"),
    BSE_ACTIVE_500_TRIGGER_NAME("BSEActive500Trigger"),
    BSE_PRICE_SHOCKERS_TRIGGER_NAME("BSEPriceShockersTrigger"),
    BSE_VOLUME_SHOCKERS_TRIGGER_NAME("BSEVolumeShockersTrigger"),

    BSE_TOP_DIVIDEND_TRIGGER_NAME("BSETopDividendTrigger"),
    BSE_MID_CAP_GAINER_TRIGGER_NAME("BSEMidCapGainerTrigger"),
    BSE_SMALL_CAP_GAINER_TRIGGER_NAME("BSESmallCapGainerTrigger"),

    BSE_SENSEX_TRIGGER_NAME("BSESensexTrigger"),
    BSE_STOCK_BASE_TRIGGER_NAME("BSEStockBaseTrigger"),

    BSE_ACTIVE_100_HISTORY_TRIGGER_NAME("BSEActive100HistoryTrigger"),
    BSE_ACTIVE_200_HISTORY_TRIGGER_NAME("BSEActive200HistoryTrigger"),
    BSE_ACTIVE_500_HISTORY_TRIGGER_NAME("BSEActive500HistoryTrigger"),
    BSE_PRICE_SHOCKER_HISTORY_TRIGGER_NAME("BSEPriceShockerHistoryTrigger"),
    BSE_VOLUME_SHOCKER_HISTORY_TRIGGER_NAME("BSEVolumeShockerHistoryTrigger");

    private String name;

    private TriggerName(String name){
        this.name = name;
    }

    public String get(){
        return this.name;
    }
}
