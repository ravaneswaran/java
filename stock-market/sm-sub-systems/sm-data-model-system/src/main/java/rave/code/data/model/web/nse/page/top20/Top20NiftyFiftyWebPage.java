package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.top20.NSETop20NiftyFiftyModel;

import java.util.List;

public class Top20NiftyFiftyWebPage extends NSEWebPage {

    private List<NSETop20NiftyFiftyModel> nseTop20NiftyFiftyModels;

    public Top20NiftyFiftyWebPage() {
        this.setNiftyFifty(true);
    }

    public List<NSETop20NiftyFiftyModel> getNseTop20NiftyFiftyModels() {
        return nseTop20NiftyFiftyModels;
    }

    public void setNseTop20NiftyFiftyModels(List<NSETop20NiftyFiftyModel> nseTop20NiftyFiftyModels) {
        this.nseTop20NiftyFiftyModels = nseTop20NiftyFiftyModels;
    }
}
