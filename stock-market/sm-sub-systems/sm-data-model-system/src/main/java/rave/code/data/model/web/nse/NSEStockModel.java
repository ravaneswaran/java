package rave.code.data.model.web.nse;

import rave.code.tech.analysis.percentage.PercentagePriceRange;

import java.util.ArrayList;
import java.util.List;

public class NSEStockModel {

    private String stockDivId;

    private String symbol;
    private String series;
    private String title;
    private double openPrice;
    private double previousClosePrice;
    private double percentageChange;
    private double lastTradedPrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
    }

    public double getPreviousClosePrice() {
        return previousClosePrice;
    }

    public void setPreviousClosePrice(double previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public String getStockDivId() {
        return stockDivId;
    }

    public void setStockDivId(String stockDivId) {
        this.stockDivId = stockDivId;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public boolean getHasLTPEqualsOrOverOpenPrice(){
        return this.lastTradedPrice >= this.openPrice;
    }

    public List<PercentagePriceRange> getPercentagePriceRanges() {
        List<PercentagePriceRange> percentagePriceRanges = new ArrayList<>();
        double[] percentages = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0};
        for (Double percentage : percentages) {
            PercentagePriceRange percentagePriceRange = new PercentagePriceRange(percentage.doubleValue(), this.getOpenPrice(), this.getLastTradedPrice());
            percentagePriceRanges.add(percentagePriceRange);
        }
        //Collections.reverse(percentagePriceRanges);
        return percentagePriceRanges;
    }
}
