package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzJobDetailEntity;

import java.util.Map;

public class QuartzJobDetailRepository extends AbstractQuartzRepository<QuartzJobDetailEntity>{

    public QuartzJobDetailRepository() {
        super(QuartzJobDetailEntity.class);
    }

    @Override
    public Map<String, QuartzJobDetailEntity> getEntityMap() {
        return Map.of();
    }
}
