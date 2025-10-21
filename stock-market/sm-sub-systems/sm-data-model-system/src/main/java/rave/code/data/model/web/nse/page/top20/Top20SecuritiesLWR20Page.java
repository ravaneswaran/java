package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.top20.NSETop20SecurityLWR20Model;

import java.util.List;

public class Top20SecuritiesLWR20Page extends NSEWebPage {

    private List<NSETop20SecurityLWR20Model> nseTop20SecurityLWR20Models;

    public Top20SecuritiesLWR20Page() {
        this.setSecurityLessThan20(true);
    }

    public List<NSETop20SecurityLWR20Model> getNseTop20SecurityLWR20Models() {
        return nseTop20SecurityLWR20Models;
    }

    public void setNseTop20SecurityLWR20Models(List<NSETop20SecurityLWR20Model> nseTop20SecurityLWR20Models) {
        this.nseTop20SecurityLWR20Models = nseTop20SecurityLWR20Models;
    }
}
