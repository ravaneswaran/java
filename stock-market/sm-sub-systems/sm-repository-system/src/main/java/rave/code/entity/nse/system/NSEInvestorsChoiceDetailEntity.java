package rave.code.entity.nse.system;

import rave.code.entity.nse.AbstractNSEEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "nse_investors_choice_detail")
@Access(AccessType.FIELD)
public class NSEInvestorsChoiceDetailEntity extends AbstractNSEEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private NSEStockBaseEntity nseStockBaseEntity;

    public NSEStockBaseEntity getNseStockBaseEntity() {
        return nseStockBaseEntity;
    }

    public void setNseStockBaseEntity(NSEStockBaseEntity nseStockBaseEntity) {
        this.nseStockBaseEntity = nseStockBaseEntity;
    }
}