package rave.code.repository.nse;

import rave.code.repository.AbstractStockBaseRepository;

import java.util.Map;

public abstract class AbstractNSERepository<T> extends AbstractStockBaseRepository<T> {

    public AbstractNSERepository(Class<T> type) {
        super(type);
    }

    @Override
    public Map<String, T> getEntityMap() {
        throw new RuntimeException("getEntityMap() says... using me without implementation is unethical...");
    }
}
