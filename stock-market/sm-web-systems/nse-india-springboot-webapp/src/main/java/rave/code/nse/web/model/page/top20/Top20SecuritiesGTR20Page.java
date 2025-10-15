package rave.code.nse.web.model.page.top20;

import rave.code.nse.web.model.top20.NSETop20SecurityGTR20Model;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20SecuritiesGTR20Page extends WebPage {

    private List<NSETop20SecurityGTR20Model> top20Models;

    public Top20SecuritiesGTR20Page(){
        this.setSecurityGreaterThan20(true);
    }

    public void setModelList(List<NSETop20SecurityGTR20Model> nseTop20SecurityGTR20Models) {
        this.top20Models = nseTop20SecurityGTR20Models;
    }

    public List<NSETop20SecurityGTR20Model> getTop20Models() {
        return top20Models;
    }
}
