package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.stock.ActiveStock;
import rave.code.data.model.web.bse.stock.CapitalGainerStock;
import rave.code.data.model.web.bse.stock.Stock;

public class StockPBRatioDecorator implements Decorator {

    @Override
    public Stock decorate(Stock stock) {
        double pbRatio = 0;

        if (stock instanceof ActiveStock) {
            pbRatio = ((ActiveStock) stock).getPriceToBookRatio() * 100;;
        } else if (stock instanceof CapitalGainerStock) {
            pbRatio = ((CapitalGainerStock) stock).getPriceToBookRatio() * 100;;
        }

        int pbRatioPercentage = 0;
        if (pbRatio <= 0) {
            pbRatioPercentage = 25;
        } else if (pbRatio >= 0 && pbRatio <= 25) {
            pbRatioPercentage = 25;
        } else if (pbRatio >= 26 && pbRatio <= 50) {
            pbRatioPercentage = 50;
        } else if (pbRatio >= 51 && pbRatio <= 75) {
            pbRatioPercentage = 75;
        } else if (pbRatio >= 76 && pbRatio <= 100) {
            pbRatioPercentage = 100;
        } else {
            pbRatioPercentage = 200;
        }

        switch (pbRatioPercentage) {
            case 25:
                stock.setPbRatioCssStyle(String.format("%s",  "color:black;background:#0BDA51;font-weight: bold;"));
                break;
            case 50:
                stock.setPbRatioCssStyle(String.format("%s", "color:black;background:yellow;font-weight: bold;"));
                break;
            case 75:
                stock.setPbRatioCssStyle(String.format("%s", "color:black;background:#FFA500;font-weight: bold;"));
                break;
            case 100:
                stock.setPbRatioCssStyle(String.format("%s", "color:black;background:#FF8DA1;font-weight: bold;"));
                break;
            default:
                stock.setPbRatioCssStyle(String.format("%s", "color:black;background:#ff0c07;font-weight: bold;"));
                break;
        }

        return stock;
    }
}
