package rave.code.entity.nse.technical;

import rave.code.entity.nse.AbstractNSEEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "nse_simple_moving_average_detail")
@Access(AccessType.FIELD)
public class NSESimpleMovingAverageDetailEntity extends AbstractNSEEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "sma_5d")
    private double SMA5D;
    @Column(name = "sma_10d")
    private double SMA10D;
    @Column(name = "sma_20d")
    private double SMA20D;
    @Column(name = "sma_50d")
    private double SMA50D;
    @Column(name = "sma_100d")
    private double SMA100D;
    @Column(name = "sma_200d")
    private double SMA200D;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public double getSMA5D() {
        return SMA5D;
    }

    public void setSMA5D(double SMA5D) {
        this.SMA5D = SMA5D;
    }

    public double getSMA10D() {
        return SMA10D;
    }

    public void setSMA10D(double SMA10D) {
        this.SMA10D = SMA10D;
    }

    public double getSMA20D() {
        return SMA20D;
    }

    public void setSMA20D(double SMA20D) {
        this.SMA20D = SMA20D;
    }

    public double getSMA50D() {
        return SMA50D;
    }

    public void setSMA50D(double SMA50D) {
        this.SMA50D = SMA50D;
    }

    public double getSMA100D() {
        return SMA100D;
    }

    public void setSMA100D(double SMA100D) {
        this.SMA100D = SMA100D;
    }

    public double getSMA200D() {
        return SMA200D;
    }

    public void setSMA200D(double SMA200D) {
        this.SMA200D = SMA200D;
    }
}
