package rave.code.repository.nse;

import rave.code.repository.AbstractStockBaseRepository;

public abstract class AbstractNSERepository<T> extends AbstractStockBaseRepository<T> {

    public AbstractNSERepository(Class<T> type) {
        super(type);
    }

}
