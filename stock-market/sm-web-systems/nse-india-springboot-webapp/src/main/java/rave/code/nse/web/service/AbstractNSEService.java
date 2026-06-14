package rave.code.nse.web.service;

import rave.code.data.model.web.nse.NSEStockModel;

import java.util.List;
import java.util.Map;

public abstract class AbstractNSEService<S, T, W> {

    public abstract W getWebPage();

    public abstract List<S> getEntities();

    public abstract List<T> transformEntities(List<S> entities);

    public abstract List<NSEStockModel> getNSEStockModels(List<S> entities);

    public Map<String, List<S>> getMappedEntities(){
        return null;
    }
}