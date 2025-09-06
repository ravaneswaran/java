package rave.code.entity.nse.csv;

import javax.persistence.*;

@Entity
@Table(name = "nse_volume_spurts_detail")
@Access(AccessType.FIELD)
public class NSEVolumeSpurtsDetailEntity extends AbstractNSECSVEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "volume")
    private int volume;
    @Column(name = "one_week_average_volume")
    private int oneWeekAverageVolume;
    @Column(name = "no_of_times")
    private double noOfTimes;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getOneWeekAverageVolume() {
        return oneWeekAverageVolume;
    }

    public void setOneWeekAverageVolume(int oneWeekAverageVolume) {
        this.oneWeekAverageVolume = oneWeekAverageVolume;
    }

    public double getNoOfTimes() {
        return noOfTimes;
    }

    public void setNoOfTimes(double noOfTimes) {
        this.noOfTimes = noOfTimes;
    }

    public String getKey(){
        return this.getSymbol();
    }
}
