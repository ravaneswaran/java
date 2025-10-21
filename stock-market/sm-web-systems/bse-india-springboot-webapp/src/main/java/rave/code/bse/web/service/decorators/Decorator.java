package rave.code.bse.web.service.decorators;

import rave.code.data.model.web.bse.BSEStockModel;

public interface Decorator {

    public BSEStockModel decorate(BSEStockModel stock);

}
