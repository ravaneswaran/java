package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzSchedulerStateEntity;

public class QuartzSchedulerStateRepository extends AbstractQuartzRepository<QuartzSchedulerStateEntity>{

    public QuartzSchedulerStateRepository() {
        super(QuartzSchedulerStateEntity.class);
    }
}
