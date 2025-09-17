package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.Job;
import rave.code.quartz.jobs.nse.csv.largetrade.block.NSEDayBlockDealDetailEntityMakerJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSEFirstBlockDealSessionScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSEFirstBlockDealSessionScheduler.class.toString());


    public NSEFirstBlockDealSessionScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs(){} {

        JobDetail nseDayBlockDealDetailEntityMakerJobDetail = newJob(NSEDayBlockDealDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_FIRST_BLOCK_DEAL_SESSION_JOB.name(), Group.NSE_BLOCK_DEAL_SESSION.name()).storeDurably()
                .build();

        Trigger nseDayBlockDealDetailEntityMakerTrigger = newTrigger()
                .withIdentity(TriggerName.NSE_FIRST_BLOCK_DEAL_SESSION_TRIGGER.name(), Group.NSE_BLOCK_DEAL_SESSION.name())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_BLOCK_DEAL_FIRST_SESSION_BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_BLOCK_DEAL_SESSION.name())
                .build();

        try {
            this.scheduler.scheduleJob(nseDayBlockDealDetailEntityMakerJobDetail, nseDayBlockDealDetailEntityMakerTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}