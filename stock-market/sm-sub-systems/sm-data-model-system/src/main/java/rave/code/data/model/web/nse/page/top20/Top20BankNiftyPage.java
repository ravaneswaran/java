package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.top20.NSETop20BankNiftyModel;
import rave.code.data.model.web.nse.WebPage;

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
