package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzLockEntity;
import rave.code.entity.quartz.id.QuartzLockId;

import java.util.Date;

public class TestQuartzLock extends TestCase {

    private QuartzLockRepository quartzLockRepository = new QuartzLockRepository();

    public void testSave(){
        QuartzLockId quartzLockId = new QuartzLockId();
        quartzLockId.setSchedulerName("STOCK_MARKET_SCHEDULER");
        quartzLockId.setLockName("TEST_LOCK_"+new Date().getTime());
        QuartzLockEntity quartzLockEntity = new QuartzLockEntity();
        quartzLockEntity.setQuartzLockId(quartzLockId);

        QuartzLockEntity returnVal = quartzLockRepository.save(quartzLockEntity);

        assertNotNull(returnVal);
    }
}
