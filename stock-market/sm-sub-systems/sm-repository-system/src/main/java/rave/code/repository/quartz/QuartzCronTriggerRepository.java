package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzCronTriggerEntity;

public class QuartzCronTriggerRepository extends AbstractQuartzRepository<QuartzCronTriggerEntity>{

    public QuartzCronTriggerRepository() {
        super(QuartzCronTriggerEntity.class);
    }
}
