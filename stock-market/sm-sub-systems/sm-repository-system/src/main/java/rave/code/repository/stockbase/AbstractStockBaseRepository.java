package rave.code.repository.stockbase;

import rave.code.repository.AbstractRepository;

import java.util.Map;

public abstract class AbstractStockBaseRepository<T> extends AbstractRepository<T> {

    public AbstractStockBaseRepository(Class<T> type) {
        super(type);
    }

    public abstract Map<String, T> getEntityMap();
}
