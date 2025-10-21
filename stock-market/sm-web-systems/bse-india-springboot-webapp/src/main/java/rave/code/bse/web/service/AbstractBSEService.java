package rave.code.bse.web.service;

import rave.code.data.model.web.bse.BSEStockModel;
import rave.code.data.model.web.bse.page.BSEWebPage;

import java.util.List;

public abstract class AbstractBSEService<S, T> {

    public BSEWebPage getWebPage() {
        BSEWebPage webPage = new BSEWebPage();

        List<S> entities = this.getEntities();
        webPage.setStocks((List<BSEStockModel>) this.transformEntities(entities));

        return webPage;
    }

    public abstract List<S> getEntities();

    public abstract List<T> transformEntities(List<S> entities);
}
