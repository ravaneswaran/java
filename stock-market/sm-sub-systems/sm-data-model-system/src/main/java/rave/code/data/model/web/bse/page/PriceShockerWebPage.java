package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.PriceShockerDetailModel;

import java.util.List;

public class PriceShockerWebPage extends BSEWebPage {

    private List<PriceShockerDetailModel> priceShockerDetailModels;

    public PriceShockerWebPage(){
        this.setPriceShockersLink(true);
    }

    public List<PriceShockerDetailModel> getPriceShockerDetailModels() {
        return priceShockerDetailModels;
    }

    public void setPriceShockerDetailModels(List<PriceShockerDetailModel> priceShockerDetailModels) {
        this.priceShockerDetailModels = priceShockerDetailModels;
    }
}
