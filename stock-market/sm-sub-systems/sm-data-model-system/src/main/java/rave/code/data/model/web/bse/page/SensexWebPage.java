package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.ActiveStockDetailModel;

import java.util.List;

public class SensexWebPage extends BSEWebPage{

    private List<ActiveStockDetailModel> activeStockDetailModels;

    public SensexWebPage(){
        this.setSensexLink(true);
    }

    public List<ActiveStockDetailModel> getActiveStockDetailModels() {
        return activeStockDetailModels;
    }

    public void setActiveStockDetailModels(List<ActiveStockDetailModel> activeStockDetailModels) {
        this.activeStockDetailModels = activeStockDetailModels;
    }
}
