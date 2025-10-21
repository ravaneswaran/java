package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.stock.Stock;

public class StockChartContainerDecorator implements Decorator{

    @Override
    public Stock decorate(Stock stock) {
        switch (stock.getCategory()){
            case "A":
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "a-group-stock"));
                break;
            case "B":
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "b-group-stock"));
                break;
            case "F":
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "f-group-stock"));
                break;
            case "S":
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "s-group-stock"));
                break;
            case "T":
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "t-group-stock"));
                break;
            case "X":
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "x-group-stock"));
                break;
            case "Z":
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "z-group-stock"));
                break;
            default:
                stock.setStockMarketChartImageDivCssStyle(String.format(Stock.STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "no-group-stock"));
                break;
        }
        return stock;
    }
}
