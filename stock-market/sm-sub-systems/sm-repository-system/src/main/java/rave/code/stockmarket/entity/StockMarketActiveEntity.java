package rave.code.stockmarket.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class StockMarketActiveEntity extends StockMarketEntity {

    @Column(name = "category")
    protected String category;
    @Column(name = "high")
    protected String high;
    @Column(name = "low")
    protected String low;
    @Column(name = "last_price")
    protected String lastPrice;
    @Column(name = "last_price_movement")
    protected String lastPriceMovement;
    @Column(name = "percentage_change")
    protected String percentageChange;
    @Column(name = "value_in_crores")
    protected String valueInCrores;
    @Column(name = "average_volume_5d")
    protected String averageVolume5Days;
    @Column(name = "average_volume_10d")
    protected String averageVolume10Days;
    @Column(name = "average_volume_30d")
    protected String averageVolume30Days;
    @Column(name = "price_to_earning_ratio")
    protected String priceToEarningRatio;
    @Column(name = "price_to_book_ratio")
    protected String priceToBookRatio;
    @Column(name = "upper_circuit")
    protected String upperCircuit;
    @Column(name = "lower_circuit")
    protected String lowerCircuit;
    @Column(name = "volume_weighted_average_price")
    protected String volumeWeightedAveragePrice;
    @Column(name = "displaced_moving_average_30d")
    protected String displacedMovingAverage30D;
    @Column(name = "displaced_moving_average_50d")
    protected String displacedMovingAverage50D;
    @Column(name = "displaced_moving_average_150d")
    protected String displacedMovingAverage150D;
    @Column(name = "displaced_moving_average_200d")
    protected String displacedMovingAverage200D;

    public StockMarketActiveEntity() {
        super();
    }


    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public String getHigh() {
        return high;
    }
    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }
    public void setLow(String low) {
        this.low = low;
    }

    public String getLastPrice() {
        return lastPrice;
    }
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLastPriceMovement() {
        return lastPriceMovement;
    }
    public void setLastPriceMovement(String lastPriceMovement) {
        this.lastPriceMovement = lastPriceMovement;
    }

    public String getPercentageChange() {
        return percentageChange;
    }
    public void setPercentageChange(String percentageChange) {
        this.percentageChange = percentageChange;
    }

    public String getValueInCrores() {
        return valueInCrores;
    }
    public void setValueInCrores(String valueInCrores) {
        this.valueInCrores = valueInCrores;
    }

    public String getAverageVolume5Days() {
        return averageVolume5Days;
    }
    public void setAverageVolume5Days(String averageVolume5Days) {
        this.averageVolume5Days = averageVolume5Days;
    }

    public String getAverageVolume10Days() {return averageVolume10Days;}
    public void setAverageVolume10Days(String averageVolume10Days) {
        this.averageVolume10Days = averageVolume10Days;
    }

    public String getAverageVolume30Days() {
        return averageVolume30Days;
    }
    public void setAverageVolume30Days(String averageVolume30Days) {
        this.averageVolume30Days = averageVolume30Days;
    }

    public String getPriceToEarningRatio() {
        return priceToEarningRatio;
    }
    public void setPriceToEarningRatio(String priceToEarningRatio) {
        this.priceToEarningRatio = priceToEarningRatio;
    }

    public String getPriceToBookRatio() {
        return priceToBookRatio;
    }
    public void setPriceToBookRatio(String priceToBookRatio) {
        this.priceToBookRatio = priceToBookRatio;
    }

    public String getUpperCircuit() {
        return upperCircuit;
    }
    public void setUpperCircuit(String upperCircuit) {
        this.upperCircuit = upperCircuit;
    }

    public String getLowerCircuit() {
        return lowerCircuit;
    }
    public void setLowerCircuit(String lowerCircuit) {
        this.lowerCircuit = lowerCircuit;
    }

    public String getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }
    public void setVolumeWeightedAveragePrice(String volumeWeightedAveragePrice) {
        this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    }

    public String getDisplacedMovingAverage30D() {
        return displacedMovingAverage30D;
    }
    public void setDisplacedMovingAverage30D(String displacedMovingAverage30D) {
        this.displacedMovingAverage30D = displacedMovingAverage30D;
    }

    public String getDisplacedMovingAverage50D() {
        return displacedMovingAverage50D;
    }
    public void setDisplacedMovingAverage50D(String displacedMovingAverage50D) {
        this.displacedMovingAverage50D = displacedMovingAverage50D;
    }


    public String getDisplacedMovingAverage150D() {
        return displacedMovingAverage150D;
    }
    public void setDisplacedMovingAverage150D(String displacedMovingAverage150D) {
        this.displacedMovingAverage150D = displacedMovingAverage150D;
    }


    public String getDisplacedMovingAverage200D() {
        return displacedMovingAverage200D;
    }
    public void setDisplacedMovingAverage200D(String displacedMovingAverage200D) {
        this.displacedMovingAverage200D = displacedMovingAverage200D;
    }
}
