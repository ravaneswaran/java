package rave.code.bse.web.service;

import java.util.List;

public abstract class AbstractBSEService<S, T, W> {

    public abstract W getWebPage();

    /*public BSEWebPage getWebPage() {
        BSEWebPage webPage = new BSEWebPage();

        List<S> entities = this.getEntities();
        webPage.setStocks((List<BSEStockModel>) this.transformEntities(entities));

        return webPage;
    }*/

    public abstract List<S> getEntities();

    public abstract List<T> transformEntities(List<S> entities);
}
