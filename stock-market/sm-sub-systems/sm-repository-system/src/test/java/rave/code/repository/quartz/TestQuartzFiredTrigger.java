package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzFiredTriggerEntity;
import rave.code.entity.quartz.id.QuartzEntryId;

import java.util.Date;

public class TestQuartzFiredTrigger extends TestCase {

    private QuartzFiredTriggerRepository quartzFiredTriggerRepository = new QuartzFiredTriggerRepository();

    public void testSave(){
        QuartzFiredTriggerEntity quartzFiredTriggerEntity = newQuartzFiredTriggerEntityInstance();

        QuartzFiredTriggerEntity returnVal = quartzFiredTriggerRepository.save(quartzFiredTriggerEntity);

        assertNotNull(returnVal);
    }

    public static QuartzFiredTriggerEntity newQuartzFiredTriggerEntityInstance(){

        QuartzEntryId quartzEntryId = new QuartzEntryId();
        quartzEntryId.setSchedulerName("STOCK_MARKET_SCHEDULER");
        quartzEntryId.setEntryId("TEST_ENTRY_ID_"+new Date().getTime());

        QuartzFiredTriggerEntity quartzFiredTriggerEntity = new QuartzFiredTriggerEntity();
        quartzFiredTriggerEntity.setQuartzEntryId(quartzEntryId);
        quartzFiredTriggerEntity.setTriggerName("TEST_TRIGGER_NAME");
        quartzFiredTriggerEntity.setTriggerGroup("TEST_TRIGGER_GROUP");
        quartzFiredTriggerEntity.setInstanceName("TEST_INSTANCE_NAME");
        quartzFiredTriggerEntity.setFiredTime(new Date().getTime());
        quartzFiredTriggerEntity.setScheduledTime(new Date().getTime());
        quartzFiredTriggerEntity.setPriority(5);
        quartzFiredTriggerEntity.setState("ACQUIRED");

        return quartzFiredTriggerEntity;
    }


}
