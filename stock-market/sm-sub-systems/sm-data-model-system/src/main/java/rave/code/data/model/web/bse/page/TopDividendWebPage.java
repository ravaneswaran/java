package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.TopDividendDetailModel;

import java.util.List;

public class TopDividendWebPage extends BSEWebPage{

    private List<TopDividendDetailModel> topDividendDetailModels;

    public TopDividendWebPage(){
        this.setTopDividendLink(true);
    }

    public List<TopDividendDetailModel> getTopDividendDetailModels() {
        return topDividendDetailModels;
    }

    public void setTopDividendDetailModels(List<TopDividendDetailModel> topDividendDetailModels) {
        this.topDividendDetailModels = topDividendDetailModels;
    }
}
