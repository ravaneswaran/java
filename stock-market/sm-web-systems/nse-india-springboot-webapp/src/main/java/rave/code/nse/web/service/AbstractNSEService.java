package rave.code.nse.web.service;

import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.data.model.web.nse.page.NSEWebPage;

import java.util.List;

public abstract class AbstractNSEService<S, T> {

    public NSEWebPage getWebPage() {
        NSEWebPage webPage = new NSEWebPage();

        List<S> entities = this.getEntities();
        webPage.setNseStockModels((List<NSEStockModel>) this.transformEntities(entities));

        return webPage;
    }

    public abstract List<S> getEntities();

    public abstract List<T> transformEntities(List<S> entities);
}