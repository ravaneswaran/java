package rave.code.entity.nse.csv;

import javax.persistence.*;

@Entity
@Table(name = "nse_price_to_earning_ratio_detail")
@Access(AccessType.FIELD)
public class NSEPriceToEarningRatioDetailEntity extends AbstractNSECSVEntity{

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "symbol_pe")
    private double symbolPE;
    @Column(name = "adjusted_pe")
    private double adjustedPE;

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

    public double getSymbolPE() {
        return symbolPE;
    }

    public void setSymbolPE(double symbolPE) {
        this.symbolPE = symbolPE;
    }

    public double getAdjustedPE() {
        return adjustedPE;
    }

    public void setAdjustedPE(double adjustedPE) {
        this.adjustedPE = adjustedPE;
    }
}
