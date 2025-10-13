package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSETop20SecurityLWR20Model;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20SecuritiesLWR20Page extends WebPage {

    private List<NSETop20SecurityLWR20Model> nseTop20SecurityLWR20Models;

    public Top20SecuritiesLWR20Page(){
        this.setSecurityLessThan20(true);
    }

    public void setModelList(List<NSETop20SecurityLWR20Model> nseTop20SecurityLWR20Models) {
        this.nseTop20SecurityLWR20Models = nseTop20SecurityLWR20Models;
    }
}
