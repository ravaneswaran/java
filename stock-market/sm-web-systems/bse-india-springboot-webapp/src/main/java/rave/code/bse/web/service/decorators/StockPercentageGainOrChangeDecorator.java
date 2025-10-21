package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.stock.ActiveStock;
import rave.code.data.model.web.bse.stock.CapitalGainerStock;
import rave.code.data.model.web.bse.stock.Stock;

public class StockPercentageGainOrChangeDecorator implements Decorator{

    @Override
    public Stock decorate(Stock stock) {
        double percentageGainOrChange = 0;
        if (stock instanceof ActiveStock) {
            percentageGainOrChange = ((ActiveStock) stock).getPercentageChange();
        } else if (stock instanceof CapitalGainerStock) {
            percentageGainOrChange = ((CapitalGainerStock) stock).getPercentageGain();
        }
        if(percentageGainOrChange < 0){
            stock.setPercentageGainCssStyle(Stock.RED_BG_CSS_STYLE);
        } else {
            stock.setPercentageGainCssStyle(Stock.GREEN_BG_CSS_STYLE);
        }
        return stock;
    }
}
