package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.BSEStockModel;

public class StockTitleDecorator implements Decorator{

    @Override
    public BSEStockModel decorate(BSEStockModel stock) {
        String category = stock.getCategory();
        category = category.substring(0,1);
        switch (category){
            case "A":
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "a-group-stock"));
                break;
            case "B":
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "b-group-stock"));
                break;
            case "F":
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "f-group-stock"));
                break;
            case "S":
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "s-group-stock"));
                break;
            case "T":
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "t-group-stock"));
                break;
            case "X":
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "x-group-stock"));
                break;
            case "Z":
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "z-group-stock"));
                break;
            default:
                stock.setTitleCssStyle(String.format(BSEStockModel.TITLE_CSS_STYLE, "no-group-stock"));
                break;
        }
        return stock;
    }
}
