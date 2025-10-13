package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSETop20BankNiftyModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class Top20BankNiftyPage extends WebPage {

    private List<NSETop20BankNiftyModel> nseTop20BankNiftyModels;

    public Top20BankNiftyPage(){
        this.setBankNifty(true);
    }

    public void setModelList(List<NSETop20BankNiftyModel> nseTop20BankNiftyModels) {
        this.nseTop20BankNiftyModels = nseTop20BankNiftyModels;
    }
}
