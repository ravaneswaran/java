package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.top20.NSETop20BankNiftyModel;

import java.util.List;

public class Top20BankNiftyPage extends NSEWebPage {

    List<NSETop20BankNiftyModel> nseTop20BankNiftyModels;

    public Top20BankNiftyPage(){
        this.setBankNifty(true);
    }

    public List<NSETop20BankNiftyModel> getNseTop20BankNiftyModels() {
        return nseTop20BankNiftyModels;
    }

    public void setNseTop20BankNiftyModels(List<NSETop20BankNiftyModel> nseTop20BankNiftyModels) {
        this.nseTop20BankNiftyModels = nseTop20BankNiftyModels;
    }
}
