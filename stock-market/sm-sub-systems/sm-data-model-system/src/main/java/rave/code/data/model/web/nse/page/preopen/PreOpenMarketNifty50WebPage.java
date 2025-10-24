package rave.code.data.model.web.nse.page.preopen;

import rave.code.data.model.web.nse.NSEPreOpenMarketModel;
import rave.code.data.model.web.nse.page.NSEWebPage;

import java.util.List;

public class PreOpenMarketNifty50WebPage extends NSEWebPage {

    private List<NSEPreOpenMarketModel> nsePreOpenMarketModels;

    public PreOpenMarketNifty50WebPage(){
        this.setPreOpenMarketNifty50(true);
    }

    public List<NSEPreOpenMarketModel> getNsePreOpenMarketModels() {
        return nsePreOpenMarketModels;
    }

    public void setNsePreOpenMarketModels(List<NSEPreOpenMarketModel> nsePreOpenMarketModels) {
        this.nsePreOpenMarketModels = nsePreOpenMarketModels;
    }
}
