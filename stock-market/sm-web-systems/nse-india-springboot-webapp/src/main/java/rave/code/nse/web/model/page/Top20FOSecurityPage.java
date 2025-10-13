package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSETop20FOSecurityModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20FOSecurityPage extends WebPage {

    private List<NSETop20FOSecurityModel> nseTop20FOSecurityModels;

    public void setModelList(List<NSETop20FOSecurityModel> nseTop20FOSecurityModels) {
        this.nseTop20FOSecurityModels = nseTop20FOSecurityModels;
    }
}
