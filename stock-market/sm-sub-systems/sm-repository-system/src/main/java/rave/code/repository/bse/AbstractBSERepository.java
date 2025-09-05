package rave.code.repository.bse;

import rave.code.repository.AbstractStockBaseRepository;

public abstract class AbstractBSERepository<T> extends AbstractStockBaseRepository<T> {

    public AbstractBSERepository(Class<T> type) {
        super(type);
    }
}
