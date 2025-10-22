package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.top20.NSETop20SecurityGTR20Model;

import java.util.List;

public class Top20SecuritiesGTR20WebPage extends NSEWebPage {

    private List<NSETop20SecurityGTR20Model> nseTop20SecurityGTR20Models;

    public Top20SecuritiesGTR20WebPage() {
        this.setSecurityGreaterThan20(true);
    }

    public List<NSETop20SecurityGTR20Model> getNseTop20SecurityGTR20Models() {
        return nseTop20SecurityGTR20Models;
    }

    public void setNseTop20SecurityGTR20Models(List<NSETop20SecurityGTR20Model> nseTop20SecurityGTR20Models) {
        this.nseTop20SecurityGTR20Models = nseTop20SecurityGTR20Models;
    }
}
