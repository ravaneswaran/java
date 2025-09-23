package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzPausedTriggerGroupEntity;

public class QuartzPausedTriggerGroupRepository extends AbstractQuartzRepository<QuartzPausedTriggerGroupEntity>{

    public QuartzPausedTriggerGroupRepository() {
        super(QuartzPausedTriggerGroupEntity.class);
    }
}
