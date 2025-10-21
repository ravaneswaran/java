package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.stock.PriceShockerStock;

import java.util.List;

public class PriceShockerWebPage extends WebPage {

    private List<PriceShockerStock> priceShockerStocks;

    public List<PriceShockerStock> getPriceShockerStocks() {
        return priceShockerStocks;
    }

    public void setPriceShockerStocks(List<PriceShockerStock> priceShockerStocks) {
        this.priceShockerStocks = priceShockerStocks;
    }
}
