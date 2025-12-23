package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.jobs.nse.mailer.NSEDailyTradeDetailsMailerJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSEDailyTradeDetailsMailerScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSEDailyTradeDetailsMailerScheduler.class.toString());

    public NSEDailyTradeDetailsMailerScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs() {
        JobDetail nseDailyTradeDetailsMailerJobDetail = newJob(NSEDailyTradeDetailsMailerJob.class)
                .withIdentity(QuartzJob.NSE_DAILY_TRADE_DETAILS_MAILER_JOB.getShortName(), QuartzGroup.NSE_DAILY_TRADE_DETAILS_MAILER.getShortName()).storeDurably()
                .build();
        Trigger nseDailyTradeDetailsMailerJobTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_DAILY_TRADE_DETAILS_MAILER.getShortName(), QuartzGroup.NSE_DAILY_TRADE_DETAILS_MAILER.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_DAILY_TRADE_DETAILS_MAILER_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_DAILY_TRADE_DETAILS_MAILER.get())
                .build();
        try {
            this.scheduler.scheduleJob(nseDailyTradeDetailsMailerJobDetail, nseDailyTradeDetailsMailerJobTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}
