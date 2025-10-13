package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSETop20NiftyFiftyModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20NiftyFiftyPage extends WebPage {

    private List<NSETop20NiftyFiftyModel> nseTop20NiftyFiftyModels;

    public Top20NiftyFiftyPage(){
        this.setNiftyFifty(true);
    }

    public void setModelList(List<NSETop20NiftyFiftyModel> nseTop20NiftyFiftyModels) {
        this.nseTop20NiftyFiftyModels = nseTop20NiftyFiftyModels;
    }
}
