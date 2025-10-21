package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.ActiveStockDetailModel;
import rave.code.data.model.web.bse.BSEStockModel;
import rave.code.data.model.web.bse.CapitalGainerDetailModel;

public class StockPercentageGainOrChangeDecorator implements Decorator{

    @Override
    public BSEStockModel decorate(BSEStockModel stock) {
        double percentageGainOrChange = 0;
        if (stock instanceof ActiveStockDetailModel) {
            percentageGainOrChange = ((ActiveStockDetailModel) stock).getPercentageChange();
        } else if (stock instanceof CapitalGainerDetailModel) {
            percentageGainOrChange = ((CapitalGainerDetailModel) stock).getPercentageGain();
        }
        if(percentageGainOrChange < 0){
            stock.setPercentageGainCssStyle(BSEStockModel.RED_BG_CSS_STYLE);
        } else {
            stock.setPercentageGainCssStyle(BSEStockModel.GREEN_BG_CSS_STYLE);
        }
        return stock;
    }
}
