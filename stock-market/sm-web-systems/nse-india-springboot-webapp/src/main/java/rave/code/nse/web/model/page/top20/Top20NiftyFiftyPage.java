package rave.code.nse.web.model.page.top20;

import rave.code.nse.web.model.top20.NSETop20NiftyFiftyModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20NiftyFiftyPage extends WebPage {

    private List<NSETop20NiftyFiftyModel> top20Models;

    public Top20NiftyFiftyPage(){
        this.setNiftyFifty(true);
    }

    public void setModelList(List<NSETop20NiftyFiftyModel> nseTop20NiftyFiftyModels) {
        this.top20Models = nseTop20NiftyFiftyModels;
    }

    public List<NSETop20NiftyFiftyModel> getTop20Models() {
        return top20Models;
    }
}
