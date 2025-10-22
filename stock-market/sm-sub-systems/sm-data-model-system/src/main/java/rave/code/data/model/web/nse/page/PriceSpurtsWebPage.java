package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;

import java.util.List;

public class PriceSpurtsWebPage extends NSEWebPage {

    private List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels;

    public PriceSpurtsWebPage(){
        this.setPriceSpurt(true);
    }

    public List<NSEPriceSpurtDetailModel> getNsePriceSpurtDetailModels() {
        return nsePriceSpurtDetailModels;
    }

    public void setNsePriceSpurtDetailModels(List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels) {
        this.nsePriceSpurtDetailModels = nsePriceSpurtDetailModels;
    }
}
