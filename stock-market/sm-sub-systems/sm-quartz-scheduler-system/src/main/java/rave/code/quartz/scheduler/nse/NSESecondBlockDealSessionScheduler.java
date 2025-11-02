package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.jobs.nse.csv.largetrade.block.NSEDayBlockDealDetailEntityMakerJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSESecondBlockDealSessionScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSESecondBlockDealSessionScheduler.class.toString());

    public NSESecondBlockDealSessionScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs(){} {

        JobDetail nseDayPriceDetailEntityMakerJob = newJob(NSEDayBlockDealDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_SECOND_BLOCK_DEAL_SESSION_JOB.getShortName(), QuartzGroup.NSE_BLOCK_DEAL_SESSION.getShortName()).storeDurably()
                .build();

        Trigger stockBaseJobTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_SECOND_BLOCK_DEAL_SESSION_TRIGGER.getShortName(), QuartzGroup.NSE_BLOCK_DEAL_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_BLOCK_DEAL_SECOND_SESSION_BETWEEN_02_05_TO_02_20_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_SECOND_BLOCK_DEAL_SESSION.get())
                .build();

        try {
            this.scheduler.scheduleJob(nseDayPriceDetailEntityMakerJob, stockBaseJobTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}