package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzTriggerEntity;

public class QuartzTriggerRepository extends AbstractQuartzRepository<QuartzTriggerEntity>{

    public QuartzTriggerRepository() {
        super(QuartzTriggerEntity.class);
    }
}
