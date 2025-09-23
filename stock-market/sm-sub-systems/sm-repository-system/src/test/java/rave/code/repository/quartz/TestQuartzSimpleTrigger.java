package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.entity.quartz.QuartzSimpleTriggerEntity;
import rave.code.entity.quartz.QuartzTriggerEntity;

public class TestQuartzSimpleTrigger extends TestCase {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();
    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();
    private QuartzSimpleTriggerRepository quartzSimpleTriggerRepository = new QuartzSimpleTriggerRepository();

    public void testSave() {
        QuartzJobDetailEntity quartzJobDetailEntity = TestQuartzJobDetail.createQuartzJobDetailEntity();
        quartzJobDetailRepository.save(quartzJobDetailEntity);
        QuartzTriggerEntity quartzTriggerEntity = TestQuartzTrigger.createQuartzTriggerEntity();
        quartzTriggerEntity.setJobName(quartzJobDetailEntity.getQuartzJobDetailId().getJobName());
        quartzTriggerEntity.setJobGroup(quartzJobDetailEntity.getQuartzJobDetailId().getJobGroup());
        quartzTriggerRepository.save(quartzTriggerEntity);
        QuartzSimpleTriggerEntity quartzSimpleTriggerEntity = new QuartzSimpleTriggerEntity();
        quartzSimpleTriggerEntity.setQuartzTriggerId(quartzTriggerEntity.getQuartzTriggerId());

        QuartzSimpleTriggerEntity returnVal = quartzSimpleTriggerRepository.save(quartzSimpleTriggerEntity);

        assertNotNull(returnVal);
    }
}
