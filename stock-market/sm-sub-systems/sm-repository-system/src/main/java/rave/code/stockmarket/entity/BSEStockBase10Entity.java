package rave.code.stockmarket.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@DiscriminatorValue("BSE")
public class BSEStockBase10Entity extends StockBase10Entity {

    public BSEStockBase10Entity(){
        this.setId(UUID.randomUUID().toString());
    }

}
