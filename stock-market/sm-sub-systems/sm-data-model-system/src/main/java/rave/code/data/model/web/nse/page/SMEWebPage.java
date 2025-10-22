package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSESMEDetailModel;

import java.util.List;

public class SMEWebPage extends NSEWebPage {

    private List<NSESMEDetailModel> nseSMEDetailModels;

    public SMEWebPage(){
        this.setSme(true);
    }

    public List<NSESMEDetailModel> getNseSMEDetailModels() {
        return nseSMEDetailModels;
    }

    public void setNseSMEDetailModels(List<NSESMEDetailModel> nseSMEDetailModels) {
        this.nseSMEDetailModels = nseSMEDetailModels;
    }
}
