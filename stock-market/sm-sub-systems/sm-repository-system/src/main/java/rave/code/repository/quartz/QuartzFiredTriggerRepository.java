package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzFiredTriggerEntity;

import java.util.Map;

public class QuartzFiredTriggerRepository extends AbstractQuartzRepository<QuartzFiredTriggerEntity>{

    public QuartzFiredTriggerRepository() {
        super(QuartzFiredTriggerEntity.class);
    }

    @Override
    public Map<String, QuartzFiredTriggerEntity> getEntityMap() {
        return Map.of();
    }
}
