package rave.code.nse.web.model.page.top20;

import rave.code.nse.web.model.top20.NSETop20FOSecurityModel;
import rave.code.nse.web.model.WebPage;

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
