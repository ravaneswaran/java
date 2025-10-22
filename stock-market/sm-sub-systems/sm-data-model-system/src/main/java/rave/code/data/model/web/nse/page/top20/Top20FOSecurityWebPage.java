package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.top20.NSETop20FOSecurityModel;

import java.util.List;

public class Top20FOSecurityWebPage extends NSEWebPage {

    private List<NSETop20FOSecurityModel> nseTop20FOSecurityModels;

    public Top20FOSecurityWebPage() {
        this.setFOSecurity(true);
    }

    public List<NSETop20FOSecurityModel> getNseTop20FOSecurityModels() {
        return nseTop20FOSecurityModels;
    }

    public void setNseTop20FOSecurityModels(List<NSETop20FOSecurityModel> nseTop20FOSecurityModels) {
        this.nseTop20FOSecurityModels = nseTop20FOSecurityModels;
    }
}
