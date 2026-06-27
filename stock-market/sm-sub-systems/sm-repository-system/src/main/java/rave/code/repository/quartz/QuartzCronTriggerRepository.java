package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzCronTriggerEntity;

import java.util.Map;

public class QuartzCronTriggerRepository extends AbstractQuartzRepository<QuartzCronTriggerEntity>{

    public QuartzCronTriggerRepository() {
        super(QuartzCronTriggerEntity.class);
    }

    @Override
    public Map<String, QuartzCronTriggerEntity> getEntityMap() {
        return Map.of();
    }
}
