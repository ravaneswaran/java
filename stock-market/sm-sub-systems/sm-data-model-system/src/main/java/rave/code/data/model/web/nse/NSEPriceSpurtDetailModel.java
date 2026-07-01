package rave.code.data.model.web.nse;

import java.util.List;

public class NSEPriceSpurtDetailModel extends NSEStockModel {

    private double highPrice;
    private double lowPrice;
    private int volume;
    private double value;
    private String at;
    private String ltpBackgroundCss;
    private List<NSEPriceSpurtDetailModel> history;

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<NSEPriceSpurtDetailModel> getHistory() {
        return history;
    }

    public void setHistory(List<NSEPriceSpurtDetailModel> history) {
        this.history = history;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getLtpBackgroundCss() {
        return ltpBackgroundCss;
    }

    public void setLtpBackgroundCss(String ltpBackgroundCss) {
        this.ltpBackgroundCss = ltpBackgroundCss;
    }
}
