package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzSimpleTriggerEntity;

public class QuartzSimpleTriggerRepository extends AbstractQuartzRepository<QuartzSimpleTriggerEntity> {

    public QuartzSimpleTriggerRepository() {
        super(QuartzSimpleTriggerEntity.class);
    }
}
