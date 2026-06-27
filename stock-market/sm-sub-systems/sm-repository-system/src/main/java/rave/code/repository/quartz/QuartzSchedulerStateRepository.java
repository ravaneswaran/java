package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzSchedulerStateEntity;

import java.util.Map;

public class QuartzSchedulerStateRepository extends AbstractQuartzRepository<QuartzSchedulerStateEntity>{

    public QuartzSchedulerStateRepository() {
        super(QuartzSchedulerStateEntity.class);
    }

    @Override
    public Map<String, QuartzSchedulerStateEntity> getEntityMap() {
        return Map.of();
    }
}
