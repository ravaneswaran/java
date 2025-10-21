package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSESMEDetailModel;

import java.util.List;

public class SMEPage extends NSEWebPage {

    private List<NSESMEDetailModel> nseSMEDetailModels;

    public SMEPage(){
        this.setSme(true);
    }

    public void setModelList(List<NSESMEDetailModel> nseSMEDetailModels) {
        this.nseSMEDetailModels = nseSMEDetailModels;
    }

    public List<NSESMEDetailModel> getNseSMEDetailModels() {
        return nseSMEDetailModels;
    }
}
