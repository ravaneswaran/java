package rave.code.entity.nse.csv;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_day_bulk_deal_detail")
@Access(AccessType.FIELD)
public class NSEDayBulkDealDetailEntity extends AbstractNSECSVEntity{

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;
    @Column(name = "business_date")
    private Date businessDate;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "security_name")
    private String securityName;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "deal_type")
    private String dealType;
    @Column(name = "quantity_traded")
    private int quantityTraded;
    @Column(name = "trade_price")
    private double tradePrice;
    @Column(name = "remarks")
    private String remarks;

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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public int getQuantityTraded() {
        return quantityTraded;
    }

    public void setQuantityTraded(int quantityTraded) {
        this.quantityTraded = quantityTraded;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}