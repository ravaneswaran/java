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

public class NSEPostCloseMarketScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSEPostCloseMarketScheduler.class.toString());

    private Scheduler scheduler;

    public NSEPostCloseMarketScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleJob(){} {

        JobDetail nseDayPriceDetailEntityMakerJob = newJob(NSEDayPriceDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_POST_MARKET_CLOSE.getName(), Group.POST_MARKET_CLOSE.name())
                .build();

        Trigger stockBaseJobTrigger = newTrigger()
                .withIdentity(TriggerName.NSE_POST_MARKET_CLOSE_TRIGGER.get(), Group.POST_MARKET_CLOSE.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_06_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.POST_MARKET_CLOSE.get())
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
