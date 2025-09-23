package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzPausedTriggerGroupEntity;
import rave.code.entity.quartz.id.QuartzPausedTriggerGroupId;

import java.util.Date;

public class TestQuartzPausedTriggerGroup extends TestCase {

    private QuartzPausedTriggerGroupRepository quartzPausedTriggerGroupRepository = new QuartzPausedTriggerGroupRepository();

    public void testSave(){
        QuartzPausedTriggerGroupId quartzPausedTriggerGroupId = new QuartzPausedTriggerGroupId();
        quartzPausedTriggerGroupId.setSchedulerName("STOCK_MARKET_SCHEDULER");
        quartzPausedTriggerGroupId.setTriggerGroup("TEST_TRIGGER_GROUP_"+new Date().getTime());
        QuartzPausedTriggerGroupEntity quartzPausedTriggerGroupEntity = new QuartzPausedTriggerGroupEntity();
        quartzPausedTriggerGroupEntity.setQuartzPausedTriggerGroupId(quartzPausedTriggerGroupId);

        QuartzPausedTriggerGroupEntity returnVal = quartzPausedTriggerGroupRepository.save(quartzPausedTriggerGroupEntity);

        assertNotNull(returnVal);
    }

}
