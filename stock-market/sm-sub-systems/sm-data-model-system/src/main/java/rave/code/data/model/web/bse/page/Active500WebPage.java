package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.ActiveStockDetailModel;

import java.util.List;

public class Active500WebPage extends BSEWebPage{

    private List<ActiveStockDetailModel> activeStockDetailModels;

    public Active500WebPage(){
        this.setActive500Link(true);
    }

    public List<ActiveStockDetailModel> getActiveStockDetailModels() {
        return activeStockDetailModels;
    }

    public void setActiveStockDetailModels(List<ActiveStockDetailModel> activeStockDetailModels) {
        this.activeStockDetailModels = activeStockDetailModels;
    }
}
