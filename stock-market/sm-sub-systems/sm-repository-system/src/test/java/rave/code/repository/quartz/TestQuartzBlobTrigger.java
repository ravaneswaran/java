package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzBlobTriggerEntity;
import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.entity.quartz.QuartzTriggerEntity;
import rave.code.entity.quartz.id.QuartzTriggerId;

public class TestQuartzBlobTrigger extends TestCase {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();
    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();
    private QuartzBlobTriggerRepository quartzBlobTriggerRepository = new QuartzBlobTriggerRepository();

    public void testSave(){
        QuartzJobDetailEntity quartzJobDetailEntity = TestQuartzJobDetail.createQuartzJobDetailEntity();
        QuartzTriggerEntity quartzTriggerEntity = TestQuartzTrigger.createQuartzTriggerEntity();
        quartzJobDetailRepository.save(quartzJobDetailEntity);
        quartzTriggerEntity.setJobName(quartzJobDetailEntity.getQuartzJobDetailId().getJobName());
        quartzTriggerEntity.setJobGroup(quartzJobDetailEntity.getQuartzJobDetailId().getJobGroup());
        quartzTriggerRepository.save(quartzTriggerEntity);
        QuartzBlobTriggerEntity quartzBlobTriggerEntity = new QuartzBlobTriggerEntity();
        QuartzTriggerId quartzTriggerId = quartzTriggerEntity.getQuartzTriggerId();
        quartzBlobTriggerEntity.setQuartzTriggerId(quartzTriggerId);
        quartzBlobTriggerEntity.setBlobData(null);

        QuartzBlobTriggerEntity returnVal = this.quartzBlobTriggerRepository.save(quartzBlobTriggerEntity);

        assertNotNull(returnVal);
    }
}
