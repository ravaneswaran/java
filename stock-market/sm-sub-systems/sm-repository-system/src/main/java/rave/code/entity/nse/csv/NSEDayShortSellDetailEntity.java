package rave.code.entity.nse.csv;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_day_short_sell_detail")
@Access(AccessType.FIELD)
public class NSEDayShortSellDetailEntity extends AbstractNSECSVEntity{

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "business_date")
    private Date businessDate;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "security_name")
    private String securityName;
    @Column(name = "quantity")
    private int quantity;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}