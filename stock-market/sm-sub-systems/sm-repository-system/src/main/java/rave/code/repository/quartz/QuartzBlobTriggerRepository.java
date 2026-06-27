package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzBlobTriggerEntity;

import java.util.Map;

public class QuartzBlobTriggerRepository extends AbstractQuartzRepository<QuartzBlobTriggerEntity>{

    public QuartzBlobTriggerRepository() {
        super(QuartzBlobTriggerEntity.class);
    }

    @Override
    public Map<String, QuartzBlobTriggerEntity> getEntityMap() {
        return Map.of();
    }
}
