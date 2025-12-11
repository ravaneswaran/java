package rave.code.repository.nse;

import rave.code.repository.AbstractRepositoryManager;

import java.util.List;
import java.util.Map;

public abstract class AbstractNSERepositoryManager<T> extends AbstractRepositoryManager<T> {

    public AbstractNSERepositoryManager(Class<T> type) {
        super(type);
    }

    @Override
    public Map<String, T> getEntityMap() {
        throw new RuntimeException("getEntityMap() says... using me without implementation is unethical...");
    }

    public abstract List<T> findLimitedEntitiesBySymbol(String symbol, int limit);
}
