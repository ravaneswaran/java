package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.top20.NSETop20NiftyNextFiftyModel;
import rave.code.data.model.web.nse.page.NSEWebPage;

import java.util.List;

public class Top20NiftyNextFiftyPage extends NSEWebPage {

    private List<NSETop20NiftyNextFiftyModel> top20Models;

    public Top20NiftyNextFiftyPage(){
        this.setNiftyNextFifty(true);
    }

    public void setModelList(List<NSETop20NiftyNextFiftyModel> nseTop20NiftyNextFiftyModels) {
        this.top20Models = nseTop20NiftyNextFiftyModels;
    }

    public List<NSETop20NiftyNextFiftyModel> getTop20Models() {
        return top20Models;
    }
}