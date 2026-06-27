package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzSimpleTriggerEntity;

import java.util.Map;

public class QuartzSimpleTriggerRepository extends AbstractQuartzRepository<QuartzSimpleTriggerEntity> {

    public QuartzSimpleTriggerRepository() {
        super(QuartzSimpleTriggerEntity.class);
    }

    @Override
    public Map<String, QuartzSimpleTriggerEntity> getEntityMap() {
        return Map.of();
    }
}
