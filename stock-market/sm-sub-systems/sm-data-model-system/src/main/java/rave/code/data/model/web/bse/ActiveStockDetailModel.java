package rave.code.data.model.web.bse;

public class ActiveStockDetailModel extends BSEStockModel {


    private double high;
    private double low;
    private double valueInCrores;
    private double percentageChange;
    private double averageVolume5D;
    private double averageVolume10D;
    private double averageVolume30D;
    private double priceToEarningRatio;
    private double priceToBookRatio;
    private double upperCircuit;
    private double lowerCircuit;
    private double volumeWeightedAveragePrice;
    private double displacedMovingAverage30D;
    private double displacedMovingAverage50D;
    private double displacedMovingAverage150D;
    private double displacedMovingAverage200D;
    private String sectorToolTip;


    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getValueInCrores() {
        return valueInCrores;
    }

    public void setValueInCrores(double valueInCrores) {
        this.valueInCrores = valueInCrores;
    }

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
    }

    public double getAverageVolume5D() {
        return averageVolume5D;
    }

    public void setAverageVolume5D(double averageVolume5D) {
        this.averageVolume5D = averageVolume5D;
    }

    public double getAverageVolume10D() {
        return averageVolume10D;
    }

    public void setAverageVolume10D(double averageVolume10D) {
        this.averageVolume10D = averageVolume10D;
    }

    public double getAverageVolume30D() {
        return averageVolume30D;
    }

    public void setAverageVolume30D(double averageVolume30D) {
        this.averageVolume30D = averageVolume30D;
    }

    public double getPriceToEarningRatio() {
        return priceToEarningRatio;
    }

    public void setPriceToEarningRatio(double priceToEarningRatio) {
        this.priceToEarningRatio = priceToEarningRatio;
    }

    public double getPriceToBookRatio() {
        return priceToBookRatio;
    }

    public void setPriceToBookRatio(double priceToBookRatio) {
        this.priceToBookRatio = priceToBookRatio;
    }

    public double getUpperCircuit() {
        return upperCircuit;
    }

    public void setUpperCircuit(double upperCircuit) {
        this.upperCircuit = upperCircuit;
    }

    public double getLowerCircuit() {
        return lowerCircuit;
    }

    public void setLowerCircuit(double lowerCircuit) {
        this.lowerCircuit = lowerCircuit;
    }

    public double getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }

    public void setVolumeWeightedAveragePrice(double volumeWeightedAveragePrice) {
        this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    }

    public double getDisplacedMovingAverage30D() {
        return displacedMovingAverage30D;
    }

    public void setDisplacedMovingAverage30D(double displacedMovingAverage30D) {
        this.displacedMovingAverage30D = displacedMovingAverage30D;
    }

    public double getDisplacedMovingAverage50D() {
        return displacedMovingAverage50D;
    }

    public void setDisplacedMovingAverage50D(double displacedMovingAverage50D) {
        this.displacedMovingAverage50D = displacedMovingAverage50D;
    }

    public double getDisplacedMovingAverage150D() {
        return displacedMovingAverage150D;
    }

    public void setDisplacedMovingAverage150D(double displacedMovingAverage150D) {
        this.displacedMovingAverage150D = displacedMovingAverage150D;
    }

    public double getDisplacedMovingAverage200D() {
        return displacedMovingAverage200D;
    }

    public void setDisplacedMovingAverage200D(double displacedMovingAverage200D) {
        this.displacedMovingAverage200D = displacedMovingAverage200D;
    }

    public String getSectorToolTip() {
        return sectorToolTip;
    }

    public void setSectorToolTip(String sectorToolTip) {
        this.sectorToolTip = sectorToolTip;
    }
}
