package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSESMEDetailModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class SMEPage extends WebPage {

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
