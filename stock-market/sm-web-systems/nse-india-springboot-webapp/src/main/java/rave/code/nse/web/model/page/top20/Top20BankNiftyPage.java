package rave.code.nse.web.model.page.top20;

import rave.code.nse.web.model.top20.NSETop20BankNiftyModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20BankNiftyPage extends WebPage {

    private List<NSETop20BankNiftyModel> top20Models;

    public Top20BankNiftyPage(){
        this.setBankNifty(true);
    }

    public void setModelList(List<NSETop20BankNiftyModel> nseTop20BankNiftyModels) {
        this.top20Models = nseTop20BankNiftyModels;
    }

    public List<NSETop20BankNiftyModel> getTop20Models() {
        return top20Models;
    }

}
