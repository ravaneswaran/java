package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzLockEntity;

import java.util.Map;

public class QuartzLockRepository extends AbstractQuartzRepository<QuartzLockEntity> {

    public QuartzLockRepository() {
        super(QuartzLockEntity.class);
    }

    @Override
    public Map<String, QuartzLockEntity> getEntityMap() {
        return Map.of();
    }
}
