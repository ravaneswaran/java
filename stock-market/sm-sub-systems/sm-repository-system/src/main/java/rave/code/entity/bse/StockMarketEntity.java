package rave.code.entity.bse;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class StockMarketEntity extends AbstractBSEEntity {

    @Id
    @Column(name = "stock_name")
    protected String stockName;

    public StockMarketEntity() {
        this.setNewEntity(true);
    }

    public String getStockName() {
        return stockName;
    }
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

}
