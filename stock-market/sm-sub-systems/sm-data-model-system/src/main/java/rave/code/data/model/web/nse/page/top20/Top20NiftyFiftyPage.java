package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.top20.NSETop20NiftyFiftyModel;
import rave.code.data.model.web.nse.WebPage;

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
