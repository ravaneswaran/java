package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.Job;
import rave.code.quartz.enums.*;
import rave.code.quartz.jobs.nse.csv.bhavcopy.NSEDayPriceDetailEntityMakerJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSEPostMarketCloseScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSEPostMarketCloseScheduler.class.toString());

    public NSEPostMarketCloseScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs(){} {

        JobDetail nseDayPriceDetailEntityMakerJobDetail = newJob(NSEDayPriceDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_POST_MARKET_CLOSE_JOB.name(), Group.NSE_POST_MARKET_CLOSE.name()).storeDurably()
                .build();

        Trigger nseDayPriceDetailEntityMakerJobTrigger = newTrigger()
                .withIdentity(TriggerName.NSE_POST_MARKET_CLOSE_TRIGGER.name(), Group.NSE_POST_MARKET_CLOSE.name())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_POST_MARKET_CLOSE_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_POST_MARKET_CLOSE.get())
                .build();

        try {
            this.scheduler.scheduleJob(nseDayPriceDetailEntityMakerJobDetail, nseDayPriceDetailEntityMakerJobTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}
