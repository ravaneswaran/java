package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzSchedulerStateEntity;
import rave.code.entity.quartz.id.QuartzInstanceId;
import rave.code.java.date.StockMarketDate;

import java.util.Date;

public class TestQuartzSchedulerState extends TestCase {

    private QuartzSchedulerStateRepository quartzSchedulerStateRepository = new QuartzSchedulerStateRepository();

    public void testSave(){
        QuartzInstanceId quartzInstanceId = new QuartzInstanceId();
        quartzInstanceId.setSchedulerName("STOCK_MARKET_SCHEDULER");
        quartzInstanceId.setInstanceName("TEST_INSTANCE_"+ StockMarketDate.getInstance().now().getTime());
        QuartzSchedulerStateEntity quartzSchedulerStateEntity = new QuartzSchedulerStateEntity();
        quartzSchedulerStateEntity.setQuartzInstanceId(quartzInstanceId);
        quartzSchedulerStateEntity.setCheckInInterval(1);
        quartzSchedulerStateEntity.setLastCheckInTime(2);

        QuartzSchedulerStateEntity returnVal = quartzSchedulerStateRepository.save(quartzSchedulerStateEntity);

        assertNotNull(returnVal);
    }
}
