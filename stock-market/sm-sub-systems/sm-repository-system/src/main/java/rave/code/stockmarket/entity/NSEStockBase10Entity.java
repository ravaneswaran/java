package rave.code.stockmarket.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Entity
@DiscriminatorValue("NSE")
public class NSEStockBase10Entity extends StockBase10Entity {

    public NSEStockBase10Entity() {
        this.setId(UUID.randomUUID().toString());
        this.setISIN("N/A");
        this.setFinancialInstrumentId("N/A");
        this.setFinancialInstrumentType("N/A");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getStockName()).append(" => ");
        stringBuilder.append("[");
        stringBuilder.append("id:").append(this.getId().trim()).append(", ");
        stringBuilder.append("mkt:").append(this.getMkt().trim()).append(", ");
        stringBuilder.append("symbol:").append(this.getStockSymbol().trim()).append(", ");
        stringBuilder.append("previous_close_price:").append(this.getPreviousClosePrice().trim()).append(", ");
        stringBuilder.append("open_price:").append(this.getOpenPrice().trim()).append(", ");
        stringBuilder.append("high_price:").append(this.getHighPrice().trim()).append(", ");
        stringBuilder.append("close_price:").append(this.getClosePrice().trim()).append(", ");
        stringBuilder.append("net_traded_value:").append(this.getNetTradedValue().trim()).append(", ");
        stringBuilder.append("net_traded_quantity:").append(this.getNetTradedQuantity().trim()).append(", ");
        stringBuilder.append("index_or_security:").append(this.getIndexOrSecurity().trim()).append(", ");
        stringBuilder.append("corp_index:").append(this.getCorpIndex().trim()).append(", ");
        stringBuilder.append("trades:").append(this.getTrades().trim()).append(", ");
        stringBuilder.append("52_week_high:").append(this.getHigh52Week().trim()).append(", ");
        stringBuilder.append("52_week_low:").append(this.getLow52Week().trim()).append(", ");
        stringBuilder.append("ISIN:").append(this.getISIN().trim()).append(", ");
        stringBuilder.append("daily_close_price:").append(this.getDailyClosePrice().trim()).append(", ");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        stringBuilder.append("created_date:").append(simpleDateFormat.format(this.getCreatedDate())).append(", ");
        stringBuilder.append("modified_date:").append(simpleDateFormat.format(this.getModifiedDate())).append(", ");
        stringBuilder.append("created_by:").append(this.getCreatedBy()).append(", ");
        stringBuilder.append("modified_by:").append(this.getModifiedBy());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}

