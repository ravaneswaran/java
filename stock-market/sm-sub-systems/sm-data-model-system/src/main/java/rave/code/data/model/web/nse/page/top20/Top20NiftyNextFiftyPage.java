package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.top20.NSETop20NiftyNextFiftyModel;

import java.util.List;

public class Top20NiftyNextFiftyPage extends NSEWebPage {

    private List<NSETop20NiftyNextFiftyModel> nseTop20NiftyNextFiftyModels;

    public Top20NiftyNextFiftyPage() {
        this.setNiftyNextFifty(true);
    }

    public List<NSETop20NiftyNextFiftyModel> getNseTop20NiftyNextFiftyModels() {
        return nseTop20NiftyNextFiftyModels;
    }

    public void setNseTop20NiftyNextFiftyModels(List<NSETop20NiftyNextFiftyModel> nseTop20NiftyNextFiftyModels) {
        this.nseTop20NiftyNextFiftyModels = nseTop20NiftyNextFiftyModels;
    }
}