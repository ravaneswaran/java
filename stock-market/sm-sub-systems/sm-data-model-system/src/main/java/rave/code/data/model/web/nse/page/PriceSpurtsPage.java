package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;

import java.util.List;

public class PriceSpurtsPage extends NSEWebPage {

    private List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels;

    public PriceSpurtsPage(){
        this.setPriceSpurt(true);
    }
}
