package rave.code.repository.quartz;

import rave.code.repository.NotThreadSafeDatabaseManager;

public abstract class AbstractQuartzRepository<T> extends NotThreadSafeDatabaseManager<T> {

    public AbstractQuartzRepository(Class<T> type) {
        super(type);
    }

}
