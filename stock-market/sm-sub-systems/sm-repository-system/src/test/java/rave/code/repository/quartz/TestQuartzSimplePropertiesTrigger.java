package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.entity.quartz.QuartzSimplePropertiesTriggerEntity;
import rave.code.entity.quartz.QuartzTriggerEntity;

public class TestQuartzSimplePropertiesTrigger extends TestCase {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();
    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();
    private QuartzSimplePropertiesTriggerRepository quartzSimplePropertiesTriggerRepository = new QuartzSimplePropertiesTriggerRepository();

    public void testSave(){
        QuartzJobDetailEntity quartzJobDetailEntity = TestQuartzJobDetail.createQuartzJobDetailEntity();
        quartzJobDetailRepository.save(quartzJobDetailEntity);
        QuartzTriggerEntity quartzTriggerEntity = TestQuartzTrigger.createQuartzTriggerEntity();
        quartzTriggerEntity.setJobName(quartzJobDetailEntity.getQuartzJobDetailId().getJobName());
        quartzTriggerEntity.setJobGroup(quartzJobDetailEntity.getQuartzJobDetailId().getJobGroup());
        QuartzSimplePropertiesTriggerEntity quartzSimplePropertiesTriggerEntity = newQuartzSimplePropertiesTriggerEntityInstance();
        quartzTriggerRepository.save(quartzTriggerEntity);
        quartzSimplePropertiesTriggerEntity.setQuartzTriggerId(quartzTriggerEntity.getQuartzTriggerId());

        QuartzSimplePropertiesTriggerEntity returnVal = quartzSimplePropertiesTriggerRepository.save(quartzSimplePropertiesTriggerEntity);

        assertNotNull(returnVal);
    }

    public static QuartzSimplePropertiesTriggerEntity newQuartzSimplePropertiesTriggerEntityInstance(){
        QuartzSimplePropertiesTriggerEntity quartzSimplePropertiesTriggerEntity = new QuartzSimplePropertiesTriggerEntity();

        return quartzSimplePropertiesTriggerEntity;
    }

}
