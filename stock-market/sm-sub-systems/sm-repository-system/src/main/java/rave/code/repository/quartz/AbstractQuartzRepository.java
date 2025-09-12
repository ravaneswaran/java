package rave.code.repository.quartz;

import rave.code.repository.DatabaseManager;

public abstract class AbstractQuartzRepository<T> extends DatabaseManager<T> {

    public AbstractQuartzRepository(Class<T> type) {
        super(type);
    }
}
