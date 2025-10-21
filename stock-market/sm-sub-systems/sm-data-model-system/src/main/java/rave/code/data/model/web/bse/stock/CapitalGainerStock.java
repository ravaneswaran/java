package rave.code.data.model.web.bse.stock;

public class CapitalGainerStock extends Stock {

    private double high;
    private double low;
    private double previousClose;
    private double variation;
    private double percentageGain;
    private double averageVolume5Days;
    private double averageVolume10Days;
    private double averageVolume30Days;
    private double displacedMovingAverage30Days;
    private double displacedMovingAverage50Days;
    private double displacedMovingAverage150Days;
    private double displacedMovingAverage200Days;
    private double priceToEarningRatio;
    private double priceToBookRatio;
    private double lowerCircuit;
    private double upperCircuit;
    private double volumeWeightedAveragePrice;

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

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }

    public double getPercentageGain() {
        return percentageGain;
    }

    public void setPercentageGain(double percentageGain) {
        this.percentageGain = percentageGain;
    }

    public double getAverageVolume5Days() {
        return averageVolume5Days;
    }

    public void setAverageVolume5Days(double averageVolume5Days) {
        this.averageVolume5Days = averageVolume5Days;
    }

    public double getAverageVolume10Days() {
        return averageVolume10Days;
    }

    public void setAverageVolume10Days(double averageVolume10Days) {
        this.averageVolume10Days = averageVolume10Days;
    }

    public double getAverageVolume30Days() {
        return averageVolume30Days;
    }

    public void setAverageVolume30Days(double averageVolume30Days) {
        this.averageVolume30Days = averageVolume30Days;
    }

    public double getDisplacedMovingAverage30Days() {
        return displacedMovingAverage30Days;
    }

    public void setDisplacedMovingAverage30Days(double displacedMovingAverage30Days) {
        this.displacedMovingAverage30Days = displacedMovingAverage30Days;
    }

    public double getDisplacedMovingAverage50Days() {
        return displacedMovingAverage50Days;
    }

    public void setDisplacedMovingAverage50Days(double displacedMovingAverage50Days) {
        this.displacedMovingAverage50Days = displacedMovingAverage50Days;
    }

    public double getDisplacedMovingAverage150Days() {
        return displacedMovingAverage150Days;
    }

    public void setDisplacedMovingAverage150Days(double displacedMovingAverage150Days) {
        this.displacedMovingAverage150Days = displacedMovingAverage150Days;
    }

    public double getDisplacedMovingAverage200Days() {
        return displacedMovingAverage200Days;
    }

    public void setDisplacedMovingAverage200Days(double displacedMovingAverage200Days) {
        this.displacedMovingAverage200Days = displacedMovingAverage200Days;
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

    public double getLowerCircuit() {
        return lowerCircuit;
    }

    public void setLowerCircuit(double lowerCircuit) {
        this.lowerCircuit = lowerCircuit;
    }

    public double getUpperCircuit() {
        return upperCircuit;
    }

    public void setUpperCircuit(double upperCircuit) {
        this.upperCircuit = upperCircuit;
    }

    public double getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }

    public void setVolumeWeightedAveragePrice(double volumeWeightedAveragePrice) {
        this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    }
}
