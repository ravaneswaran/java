package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.stock.ActiveStock;
import rave.code.data.model.web.bse.stock.CapitalGainerStock;
import rave.code.data.model.web.bse.stock.Stock;

public class StockPERatioDecorator implements Decorator {

    @Override
    public Stock decorate(Stock stock) {
        double peRatio = 0;

        if (stock instanceof ActiveStock) {
            peRatio = ((ActiveStock) stock).getPriceToEarningRatio();;
        } else if (stock instanceof CapitalGainerStock) {
            peRatio = ((CapitalGainerStock) stock).getPriceToEarningRatio();;
        }

        if(peRatio <= 25){
            stock.setPeRatioCssStyle(String.format("%s",  "color:black;background:#0BDA51;font-weight: bold;"));
        } else {
            stock.setPeRatioCssStyle(String.format("%s", "color:black;background:#ff0c07;font-weight: bold;"));
        }

        return stock;
    }
}