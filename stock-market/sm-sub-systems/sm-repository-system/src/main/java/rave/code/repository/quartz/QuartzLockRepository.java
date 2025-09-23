package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzLockEntity;

public class QuartzLockRepository extends AbstractQuartzRepository<QuartzLockEntity> {

    public QuartzLockRepository() {
        super(QuartzLockEntity.class);
    }
}
