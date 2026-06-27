package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzCalendarEntity;

import java.util.Map;

public class QuartzCalendarRepository extends AbstractQuartzRepository<QuartzCalendarEntity>{

    public QuartzCalendarRepository() {
        super(QuartzCalendarEntity.class);
    }

    @Override
    public Map<String, QuartzCalendarEntity> getEntityMap() {
        return Map.of();
    }
}
