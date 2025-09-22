package rave.code.repository.quartz;

import rave.code.repository.ThreadSafeDatabaseManager;

public abstract class AbstractQuartzRepository<T> extends ThreadSafeDatabaseManager<T> {

    public AbstractQuartzRepository(Class<T> type) {
        super(type);
    }
}
