package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.top20.NSETop20NiftyFiftyModel;
import rave.code.data.model.web.nse.page.NSEWebPage;

import java.util.List;

public class Top20NiftyFiftyPage extends NSEWebPage {

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
