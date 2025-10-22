package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.CapitalGainerDetailModel;

import java.util.List;

public class MidCapGainerWebPage extends BSEWebPage{

    private List<CapitalGainerDetailModel> capitalGainerDetailModels;

    public MidCapGainerWebPage(){
        this.setMidCapGainerLink(true);
    }

    public List<CapitalGainerDetailModel> getCapitalGainerDetailModels() {
        return capitalGainerDetailModels;
    }

    public void setCapitalGainerDetailModels(List<CapitalGainerDetailModel> capitalGainerDetailModels) {
        this.capitalGainerDetailModels = capitalGainerDetailModels;
    }
}
