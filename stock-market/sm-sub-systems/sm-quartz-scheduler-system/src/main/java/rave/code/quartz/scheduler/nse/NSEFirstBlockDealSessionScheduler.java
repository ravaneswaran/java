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

    private Scheduler scheduler;

    public NSEFirstBlockDealSessionScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleJob(){} {

        JobDetail nseDayPriceDetailEntityMakerJob = newJob(NSEDayBlockDealDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_FIRST_BLOCK_DEAL_SESSION.getName(), Group.BLOCK_DEAL_SESSION.name())
                .build();

        Trigger stockBaseJobTrigger = newTrigger()
                .withIdentity(TriggerName.NSE_BLOCK_DEAL_SESSION_TRIGGER.get(), Group.BLOCK_DEAL_SESSION.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BLOCK_DEAL_SESSION.get())
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