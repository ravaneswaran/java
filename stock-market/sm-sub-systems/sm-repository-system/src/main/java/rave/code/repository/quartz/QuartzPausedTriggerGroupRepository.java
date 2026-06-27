package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzPausedTriggerGroupEntity;

import java.util.Map;

public class QuartzPausedTriggerGroupRepository extends AbstractQuartzRepository<QuartzPausedTriggerGroupEntity>{

    public QuartzPausedTriggerGroupRepository() {
        super(QuartzPausedTriggerGroupEntity.class);
    }

    @Override
    public Map<String, QuartzPausedTriggerGroupEntity> getEntityMap() {
        return Map.of();
    }
}
