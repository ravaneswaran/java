package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzCalendarEntity;

public class QuartzCalendarRepository extends AbstractQuartzRepository<QuartzCalendarEntity>{

    public QuartzCalendarRepository() {
        super(QuartzCalendarEntity.class);
    }
}
