package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSETop20SecurityGTR20Model;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20SecuritiesGTR20Page extends WebPage {

    private List<NSETop20SecurityGTR20Model> nseTop20SecurityGTR20Models;

    public Top20SecuritiesGTR20Page(){
        this.setSecurityGreaterThan20(true);
    }

    public void setModelList(List<NSETop20SecurityGTR20Model> nseTop20SecurityGTR20Models) {
        this.nseTop20SecurityGTR20Models = nseTop20SecurityGTR20Models;
    }

    public List<NSETop20SecurityGTR20Model> getNseTop20SecurityGTR20Models() {
        return nseTop20SecurityGTR20Models;
    }
}
