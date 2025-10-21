package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.BSEStockModel;

public class StockLastPriceDecorator implements Decorator{

    @Override
    public BSEStockModel decorate(BSEStockModel stock) {
        stock.setLastPriceCssStyle(BSEStockModel.MAUVE_PINK_BG_CSS_STYLE);
        return stock;
    }
}
