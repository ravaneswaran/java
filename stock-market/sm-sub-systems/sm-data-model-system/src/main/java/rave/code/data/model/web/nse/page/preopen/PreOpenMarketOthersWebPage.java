package rave.code.data.model.web.nse.page.preopen;

import rave.code.data.model.web.nse.NSEPreOpenMarketModel;
import rave.code.data.model.web.nse.page.NSEWebPage;

import java.util.List;

public class PreOpenMarketOthersWebPage extends NSEWebPage {

    private List<NSEPreOpenMarketModel> nsePreOpenMarketModels;

    public PreOpenMarketOthersWebPage(){
        this.setPreOpenMarketOthers(true);
    }

    public List<NSEPreOpenMarketModel> getNsePreOpenMarketModels() {
        return nsePreOpenMarketModels;
    }

    public void setNsePreOpenMarketModels(List<NSEPreOpenMarketModel> nsePreOpenMarketModels) {
        this.nsePreOpenMarketModels = nsePreOpenMarketModels;
    }
}
