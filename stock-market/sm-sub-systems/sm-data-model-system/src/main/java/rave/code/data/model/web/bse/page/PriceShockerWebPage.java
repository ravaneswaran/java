package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.PriceShockerDetailModel;

import java.util.List;

public class PriceShockerWebPage extends BSEWebPage {

    private List<PriceShockerDetailModel> priceShockerStocks;

    public List<PriceShockerDetailModel> getPriceShockerStocks() {
        return priceShockerStocks;
    }

    public void setPriceShockerStocks(List<PriceShockerDetailModel> priceShockerStocks) {
        this.priceShockerStocks = priceShockerStocks;
    }
}
