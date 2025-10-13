package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSETop20NiftyNextFiftyModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20NiftyNextFiftyPage extends WebPage {

    private List<NSETop20NiftyNextFiftyModel> nseTop20NiftyNextFiftyModels;

    public Top20NiftyNextFiftyPage(){
        this.setNiftyNextFifty(true);
    }

    public void setModelList(List<NSETop20NiftyNextFiftyModel> nseTop20NiftyNextFiftyModels) {
        this.nseTop20NiftyNextFiftyModels = nseTop20NiftyNextFiftyModels;
    }
}