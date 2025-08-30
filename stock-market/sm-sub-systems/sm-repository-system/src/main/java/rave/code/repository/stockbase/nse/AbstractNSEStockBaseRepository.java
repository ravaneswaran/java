package rave.code.repository.stockbase.nse;

import rave.code.repository.stockbase.AbstractStockBaseRepository;

public abstract class AbstractNSEStockBaseRepository<T> extends AbstractStockBaseRepository<T> {

    public AbstractNSEStockBaseRepository(Class<T> type) {
        super(type);
    }
}
