package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzSimplePropertiesTriggerEntity;

import java.util.Map;

public class QuartzSimplePropertiesTriggerRepository extends AbstractQuartzRepository<QuartzSimplePropertiesTriggerEntity> {

    public QuartzSimplePropertiesTriggerRepository() {
        super(QuartzSimplePropertiesTriggerEntity.class);
    }

    @Override
    public Map<String, QuartzSimplePropertiesTriggerEntity> getEntityMap() {
        return Map.of();
    }
}
