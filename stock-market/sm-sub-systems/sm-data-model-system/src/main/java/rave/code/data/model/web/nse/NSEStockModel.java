package rave.code.data.model.web.nse;

import rave.code.tech.analysis.pricerange.percentage.PercentagePriceRange;

import java.util.ArrayList;
import java.util.List;

public class NSEStockModel {

    private String stockDivId;

    private String symbol;
    private double openPrice;
    private double previousClosePrice;
    private double percentageChange;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public List<PercentagePriceRange> getPercentagePriceRanges() {
        List<PercentagePriceRange> percentagePriceRanges = new ArrayList<>();
        double[] percentages = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2};
        for (Double percentage : percentages) {
            PercentagePriceRange percentagePriceRange = new PercentagePriceRange(percentage.doubleValue(), this.getOpenPrice());
            percentagePriceRanges.add(percentagePriceRange);
        }
        //Collections.reverse(percentagePriceRanges);
        return percentagePriceRanges;
    }
}
