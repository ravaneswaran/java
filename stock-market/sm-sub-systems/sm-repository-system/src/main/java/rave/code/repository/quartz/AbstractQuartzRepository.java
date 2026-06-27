package rave.code.repository.quartz;

import rave.code.repository.AbstractRepositoryManager;

public abstract class AbstractQuartzRepository<T> extends AbstractRepositoryManager<T> {

    public AbstractQuartzRepository(Class<T> type) {
        super(type);
    }

}
