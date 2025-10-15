package rave.code.nse.web.model.page.top20;

import rave.code.nse.web.model.top20.NSETop20SecurityLWR20Model;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20SecuritiesLWR20Page extends WebPage {

    private List<NSETop20SecurityLWR20Model> top20Models;

    public Top20SecuritiesLWR20Page(){
        this.setSecurityLessThan20(true);
    }

    public void setModelList(List<NSETop20SecurityLWR20Model> nseTop20SecurityLWR20Models) {
        this.top20Models = nseTop20SecurityLWR20Models;
    }

    public List<NSETop20SecurityLWR20Model> getTop20Models() {
        return top20Models;
    }
}
