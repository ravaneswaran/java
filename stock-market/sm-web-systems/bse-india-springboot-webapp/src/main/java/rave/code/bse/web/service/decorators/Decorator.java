package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.stock.Stock;

public interface Decorator {

    public Stock decorate(Stock stock);

}
