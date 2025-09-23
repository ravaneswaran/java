package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzBlobTriggerEntity;

public class QuartzBlobTriggerRepository extends AbstractQuartzRepository<QuartzBlobTriggerEntity>{

    public QuartzBlobTriggerRepository() {
        super(QuartzBlobTriggerEntity.class);
    }

}
