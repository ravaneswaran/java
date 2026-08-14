package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.jobs.nse.histories.NSEPreOpenMarketDetailHistoryEntityMakerJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSEPreOpenMarketHistoryScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSEPreOpenMarketHistoryScheduler.class.toString());

    public NSEPreOpenMarketHistoryScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs() {
        JobDetail nsePreOpenMarketDetailHistoryEntityMakerJobDetail = newJob(NSEPreOpenMarketDetailHistoryEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_PRE_OPEN_MARKET_HISTORY_JOB.getShortName(), QuartzGroup.NSE_PRE_OPEN_MARKET_HISTORY.getShortName()).storeDurably()
                .build();

        Trigger nsePreOpenMarketDetailHistoryEntityMakerJobTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_PRE_OPEN_MARKET_HISTORY_TRIGGER.getShortName(), QuartzGroup.NSE_PRE_OPEN_MARKET_HISTORY.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_PRE_OPEN_MARKET_HISTORY_AT_09_10_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_PRE_OPEN_MARKET_HISTORY.get())
                .build();

        try {
            this.scheduler.scheduleJob(nsePreOpenMarketDetailHistoryEntityMakerJobDetail, nsePreOpenMarketDetailHistoryEntityMakerJobTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}

