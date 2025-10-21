package rave.code.data.model.web.bse;

public class TopDividendDetailModel extends BSEStockModel {

    private double latestDividendPercentage;
    private double dividendYieldPercentage52High;
    private double dividendYieldPercentage52Low;
    private double dividendYieldPercentageAtCurrent;

    public double getLatestDividendPercentage() {
        return latestDividendPercentage;
    }

    public void setLatestDividendPercentage(double latestDividendPercentage) {
        this.latestDividendPercentage = latestDividendPercentage;
    }

    public double getDividendYieldPercentage52High() {
        return dividendYieldPercentage52High;
    }

    public void setDividendYieldPercentage52High(double dividendYieldPercentage52High) {
        this.dividendYieldPercentage52High = dividendYieldPercentage52High;
    }

    public double getDividendYieldPercentage52Low() {
        return dividendYieldPercentage52Low;
    }

    public void setDividendYieldPercentage52Low(double dividendYieldPercentage52Low) {
        this.dividendYieldPercentage52Low = dividendYieldPercentage52Low;
    }

    public double getDividendYieldPercentageAtCurrent() {
        return dividendYieldPercentageAtCurrent;
    }

    public void setDividendYieldPercentageAtCurrent(double dividendYieldPercentageAtCurrent) {
        this.dividendYieldPercentageAtCurrent = dividendYieldPercentageAtCurrent;
    }
}
