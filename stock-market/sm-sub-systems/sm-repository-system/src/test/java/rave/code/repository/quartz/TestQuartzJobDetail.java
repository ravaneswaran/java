package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.entity.quartz.id.QuartzJobDetailId;

import java.util.Date;

public class TestQuartzJobDetail extends TestCase {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();

    public void testSave(){
        QuartzJobDetailEntity quartzJobDetailEntity = TestQuartzJobDetail.createQuartzJobDetailEntity();
        QuartzJobDetailEntity returnVal = quartzJobDetailRepository.save(quartzJobDetailEntity);
        assertNotNull(returnVal);
    }

    public static QuartzJobDetailEntity createQuartzJobDetailEntity(){

        QuartzJobDetailId quartzJobDetailId = new QuartzJobDetailId();
        quartzJobDetailId.setSchedulerName("STOCK_MARKET_SCHEDULER");
        quartzJobDetailId.setJobName("TEST_JOB_"+new Date().getTime());
        quartzJobDetailId.setJobGroup("TEST_JOBS");

        QuartzJobDetailEntity quartzJobDetailEntity = new QuartzJobDetailEntity();
        quartzJobDetailEntity.setQuartzJobDetailId(quartzJobDetailId);
        quartzJobDetailEntity.setDescription("TEST_DESCRIPTION");
        quartzJobDetailEntity.setJobClassName("TestClass_"+new Date().getTime());
        quartzJobDetailEntity.setIsDurable("1");
        quartzJobDetailEntity.setIsNonConcurrent("0");
        quartzJobDetailEntity.setIsUpdateData("0");
        quartzJobDetailEntity.setRequestRecovery("0");
        quartzJobDetailEntity.setJobData(null);

        return quartzJobDetailEntity;
    }
}
