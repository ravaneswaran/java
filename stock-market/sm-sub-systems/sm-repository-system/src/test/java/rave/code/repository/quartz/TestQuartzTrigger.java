package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.entity.quartz.QuartzTriggerEntity;
import rave.code.entity.quartz.id.QuartzTriggerId;
import rave.code.java.date.StockMarketDate;

import java.util.Date;

public class TestQuartzTrigger extends TestCase {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();
    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();

    public void testSave(){
        QuartzJobDetailEntity quartzJobDetailEntity = TestQuartzJobDetail.createQuartzJobDetailEntity();
        this.quartzJobDetailRepository.save(quartzJobDetailEntity);
        QuartzTriggerEntity quartzTriggerEntity = createQuartzTriggerEntity();
        quartzTriggerEntity.setJobName(quartzJobDetailEntity.getQuartzJobDetailId().getJobName());
        quartzTriggerEntity.setJobGroup(quartzJobDetailEntity.getQuartzJobDetailId().getJobGroup());

        QuartzTriggerEntity returnVal = this.quartzTriggerRepository.save(quartzTriggerEntity);

        assertNotNull(returnVal);
    }

    public static QuartzTriggerEntity createQuartzTriggerEntity(){
        QuartzTriggerId quartzTriggerId = new QuartzTriggerId();
        quartzTriggerId.setTriggerGroup("BLOB_TRIGGERS");
        quartzTriggerId.setTriggerName("TEST_BLOB_TRIGGER_"+ StockMarketDate.getInstance().now().getTime());
        quartzTriggerId.setSchedulerName("STOCK_MARKET_SCHEDULER");

        QuartzTriggerEntity quartzTriggerEntity = new QuartzTriggerEntity();
        quartzTriggerEntity.setQuartzTriggerId(quartzTriggerId);
        quartzTriggerEntity.setTriggerState("TEST_STATE");
        quartzTriggerEntity.setTriggerType("001");
        quartzTriggerEntity.setStartTime(StockMarketDate.getInstance().now().getTime());

        return quartzTriggerEntity;
    }
}
