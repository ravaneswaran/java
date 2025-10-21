package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.ActiveStockDetailModel;
import rave.code.data.model.web.bse.CapitalGainerDetailModel;
import rave.code.data.model.web.bse.BSEStockModel;

public class StockPERatioDecorator implements Decorator {

    @Override
    public BSEStockModel decorate(BSEStockModel stock) {
        double peRatio = 0;

        if (stock instanceof ActiveStockDetailModel) {
            peRatio = ((ActiveStockDetailModel) stock).getPriceToEarningRatio();;
        } else if (stock instanceof CapitalGainerDetailModel) {
            peRatio = ((CapitalGainerDetailModel) stock).getPriceToEarningRatio();;
        }

        if(peRatio <= 25){
            stock.setPeRatioCssStyle(String.format("%s",  "color:black;background:#0BDA51;font-weight: bold;"));
        } else {
            stock.setPeRatioCssStyle(String.format("%s", "color:black;background:#ff0c07;font-weight: bold;"));
        }

        return stock;
    }
}