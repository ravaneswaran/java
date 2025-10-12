package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSEPriceSpurtDetailModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class PriceSpurtsPage extends WebPage {

    private List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels;

    public void setModelList(List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels) {
        this.nsePriceSpurtDetailModels = nsePriceSpurtDetailModels;
    }
}
