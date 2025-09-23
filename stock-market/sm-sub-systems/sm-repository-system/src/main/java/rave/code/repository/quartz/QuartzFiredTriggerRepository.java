package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzFiredTriggerEntity;

public class QuartzFiredTriggerRepository extends AbstractQuartzRepository<QuartzFiredTriggerEntity>{

    public QuartzFiredTriggerRepository() {
        super(QuartzFiredTriggerEntity.class);
    }
}
