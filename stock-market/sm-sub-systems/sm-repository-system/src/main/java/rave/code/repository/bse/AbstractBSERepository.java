package rave.code.repository.bse;

import rave.code.repository.AbstractRepositoryManager;

public abstract class AbstractBSERepository<T> extends AbstractRepositoryManager<T> {

    public AbstractBSERepository(Class<T> type) {
        super(type);
    }
}
