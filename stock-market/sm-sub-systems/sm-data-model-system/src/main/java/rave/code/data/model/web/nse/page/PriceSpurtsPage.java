package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.data.model.web.nse.WebPage;

import java.util.List;

public class PriceSpurtsPage extends WebPage {

    private List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels;

    public PriceSpurtsPage(){
        this.setPriceSpurt(true);
    }

    public void setModelList(List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels) {
        this.nsePriceSpurtDetailModels = nsePriceSpurtDetailModels;
    }

    public List<NSEPriceSpurtDetailModel> getNsePriceSpurtDetailModels() {
        return nsePriceSpurtDetailModels;
    }
}
