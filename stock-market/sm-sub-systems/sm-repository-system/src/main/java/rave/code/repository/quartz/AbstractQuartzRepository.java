package rave.code.repository.quartz;

import rave.code.repository.AbstractRepository;

public abstract class AbstractQuartzRepository<T> extends AbstractRepository<T> {

    public AbstractQuartzRepository(Class<T> type) {
        super(type);
    }
}
