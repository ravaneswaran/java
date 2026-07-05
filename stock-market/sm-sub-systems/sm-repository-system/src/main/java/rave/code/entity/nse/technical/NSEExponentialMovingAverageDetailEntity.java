package rave.code.entity.nse.technical;

import rave.code.entity.nse.AbstractNSEEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "nse_exponential_moving_average_detail")
@Access(AccessType.FIELD)
public class NSEExponentialMovingAverageDetailEntity extends AbstractNSEEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "ema_5d")
    private double EMA5D;
    @Column(name = "ema_10d")
    private double EMA10D;
    @Column(name = "ema_20d")
    private double EMA20D;
    @Column(name = "ema_50d")
    private double EMA50D;
    @Column(name = "ema_100d")
    private double EMA100D;
    @Column(name = "ema_200d")
    private double EMA200D;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public double getEMA5D() {
        return EMA5D;
    }

    public void setEMA5D(double EMA5D) {
        this.EMA5D = EMA5D;
    }

    public double getEMA10D() {
        return EMA10D;
    }

    public void setEMA10D(double EMA10D) {
        this.EMA10D = EMA10D;
    }

    public double getEMA20D() {
        return EMA20D;
    }

    public void setEMA20D(double EMA20D) {
        this.EMA20D = EMA20D;
    }

    public double getEMA50D() {
        return EMA50D;
    }

    public void setEMA50D(double EMA50D) {
        this.EMA50D = EMA50D;
    }

    public double getEMA100D() {
        return EMA100D;
    }

    public void setEMA100D(double EMA100D) {
        this.EMA100D = EMA100D;
    }

    public double getEMA200D() {
        return EMA200D;
    }

    public void setEMA200D(double EMA200D) {
        this.EMA200D = EMA200D;
    }
}
