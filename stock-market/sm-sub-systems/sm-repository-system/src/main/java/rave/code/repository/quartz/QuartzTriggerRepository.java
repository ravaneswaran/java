package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzTriggerEntity;

import java.util.Map;

public class QuartzTriggerRepository extends AbstractQuartzRepository<QuartzTriggerEntity>{

    public QuartzTriggerRepository() {
        super(QuartzTriggerEntity.class);
    }

    @Override
    public Map<String, QuartzTriggerEntity> getEntityMap() {
        return Map.of();
    }
}
