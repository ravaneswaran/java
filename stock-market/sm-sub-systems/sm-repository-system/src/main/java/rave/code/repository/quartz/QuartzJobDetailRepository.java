package rave.code.repository.quartz;

import rave.code.entity.quartz.QuartzJobDetailEntity;

public class QuartzJobDetailRepository extends AbstractQuartzRepository<QuartzJobDetailEntity>{

    public QuartzJobDetailRepository() {
        super(QuartzJobDetailEntity.class);
    }

}
