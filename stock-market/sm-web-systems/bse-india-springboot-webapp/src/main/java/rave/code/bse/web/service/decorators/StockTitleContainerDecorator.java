package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.BSEStockModel;

public class StockTitleContainerDecorator implements Decorator{

    @Override
    public BSEStockModel decorate(BSEStockModel stock) {
        switch (stock.getCategory()){
            case "A":
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "a-group-stock"));
                break;
            case "B":
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "b-group-stock"));
                break;
            case "F":
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "f-group-stock"));
                break;
            case "S":
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "s-group-stock"));
                break;
            case "T":
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "t-group-stock"));
                break;
            case "X":
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "x-group-stock"));
                break;
            case "Z":
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "z-group-stock"));
                break;
            default:
                stock.setTitleContainerCssStyle(String.format(BSEStockModel.TITLE_CONTAINER_CSS_STYLE, "no-group-stock"));
                break;
        }
        return stock;
    }
}
