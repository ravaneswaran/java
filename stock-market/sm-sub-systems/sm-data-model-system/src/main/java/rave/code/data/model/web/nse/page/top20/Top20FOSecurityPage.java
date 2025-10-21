package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.top20.NSETop20FOSecurityModel;
import rave.code.data.model.web.nse.WebPage;

import java.util.List;

public class Top20FOSecurityPage extends WebPage {

    private List<NSETop20FOSecurityModel> top20Models;

    public Top20FOSecurityPage(){
        this.setFOSecurity(true);
    }

    public void setModelList(List<NSETop20FOSecurityModel> nseTop20FOSecurityModels) {
        this.top20Models = nseTop20FOSecurityModels;
    }

    public List<NSETop20FOSecurityModel> getTop20Models() {
        return top20Models;
    }
}
