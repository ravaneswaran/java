package rave.code.repository.stockbase.nse.webpage;

import rave.code.repository.stockbase.nse.AbstractNSEStockBaseRepository;

public abstract class AbstractNSEStockBaseWebPageRepository<T> extends AbstractNSEStockBaseRepository<T> {

    public AbstractNSEStockBaseWebPageRepository(Class<T> type) {
        super(type);
    }
}
