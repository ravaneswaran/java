package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzCronTriggerEntity;
import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.entity.quartz.QuartzTriggerEntity;
import rave.code.entity.quartz.id.QuartzTriggerId;

public class TestQuartzCronTrigger extends TestCase {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();
    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();
    private QuartzCronTriggerRepository quartzCronTriggerRepository = new QuartzCronTriggerRepository();

    public void testSave() {
        QuartzJobDetailEntity quartzJobDetailEntity = TestQuartzJobDetail.createQuartzJobDetailEntity();
        QuartzTriggerEntity quartzTriggerEntity = TestQuartzTrigger.createQuartzTriggerEntity();
        quartzJobDetailRepository.save(quartzJobDetailEntity);
        quartzTriggerEntity.setJobName(quartzJobDetailEntity.getQuartzJobDetailId().getJobName());
        quartzTriggerEntity.setJobGroup(quartzJobDetailEntity.getQuartzJobDetailId().getJobGroup());
        quartzTriggerRepository.save(quartzTriggerEntity);
        QuartzTriggerId quartzTriggerId = quartzTriggerEntity.getQuartzTriggerId();
        QuartzCronTriggerEntity quartzCronTriggerEntity = new QuartzCronTriggerEntity();
        quartzCronTriggerEntity.setQuartzTriggerId(quartzTriggerId);
        quartzCronTriggerEntity.setCronExpression("TEST_EXPRESSION");

        QuartzCronTriggerEntity returnVal = quartzCronTriggerRepository.save(quartzCronTriggerEntity);

        assertNotNull(returnVal);
    }
}
