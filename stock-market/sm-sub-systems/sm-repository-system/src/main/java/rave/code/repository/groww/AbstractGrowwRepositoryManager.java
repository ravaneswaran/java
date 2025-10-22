package rave.code.repository.groww;

import rave.code.repository.AbstractRepositoryManager;

import java.util.Map;

public abstract class AbstractGrowwRepositoryManager <T> extends AbstractRepositoryManager<T> {

    public AbstractGrowwRepositoryManager(Class<T> type) {
        super(type);
    }

    @Override
    public Map<String, T> getEntityMap() {
        throw new RuntimeException("getEntityMap() says... using me without implementation is unethical...");
    }
}
