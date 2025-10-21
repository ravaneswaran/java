package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.jobs.nse.csv.preopen.*;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSERegularPreOpenSessionScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSERegularPreOpenSessionScheduler.class.toString());

    public NSERegularPreOpenSessionScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs(){} {

        JobDetail nsePreOpenMarketNifty50EntityMakerJobDetail = newJob(NSEPreOpenMarketNifty50EntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_PRE_OPEN_MARKET_NIFTY_50_REGULAR_SESSION_JOB.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get()).storeDurably()
                .build();
        JobDetail nsePreOpenMarketBankNiftyEntityMakerJobDetail = newJob(NSEPreOpenMarketBankNiftyEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_PRE_OPEN_MARKET_BANK_NIFTY_REGULAR_SESSION_JOB.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get()).storeDurably()
                .build();
        JobDetail nsePreOpenMarketSMEEntityMakerJobDetail = newJob(NSEPreOpenMarketSMEEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_PRE_OPEN_MARKET_SME_REGULAR_SESSION_JOB.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get()).storeDurably()
                .build();
        JobDetail nsePreOpenMarketFOEntityMakerJobDetail = newJob(NSEPreOpenMarketFOEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_PRE_OPEN_MARKET_FO_REGULAR_SESSION_JOB.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get()).storeDurably()
                .build();
        JobDetail nsePreOpenMarketOthersEntityMakerJobDetail = newJob(NSEPreOpenMarketOthersEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_PRE_OPEN_MARKET_OTHERS_REGULAR_SESSION_JOB.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get()).storeDurably()
                .build();

        Trigger preOpenMarketNifty50RegularSessionTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_PRE_OPEN_MARKET_NIFTY_50_REGULAR_SESSION_TRIGGER.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_PRE_OPEN_SESSION_BETWEEN_09_00_TO_09_08_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .build();

        Trigger preOpenMarketBankNiftyRegularSessionTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_PRE_OPEN_MARKET_BANK_NIFTY_REGULAR_SESSION_TRIGGER.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_PRE_OPEN_SESSION_BETWEEN_09_00_TO_09_08_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .build();

        Trigger preOpenMarketRegularSMESessionTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_PRE_OPEN_MARKET_SME_REGULAR_SESSION_TRIGGER.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_PRE_OPEN_SESSION_BETWEEN_09_00_TO_09_08_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .build();

        Trigger preOpenMarketRegularFOSessionTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_PRE_OPEN_MARKET_FO_REGULAR_SESSION_TRIGGER.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_PRE_OPEN_SESSION_BETWEEN_09_00_TO_09_08_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .build();

        Trigger preOpenMarketRegularOthersSessionTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_PRE_OPEN_MARKET_OTHERS_REGULAR_SESSION_TRIGGER.get(), QuartzGroup.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_PRE_OPEN_SESSION_BETWEEN_09_00_TO_09_08_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .build();

        try {
            this.scheduler.scheduleJob(nsePreOpenMarketNifty50EntityMakerJobDetail, preOpenMarketNifty50RegularSessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketBankNiftyEntityMakerJobDetail, preOpenMarketBankNiftyRegularSessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketSMEEntityMakerJobDetail, preOpenMarketRegularSMESessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketFOEntityMakerJobDetail, preOpenMarketRegularFOSessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketOthersEntityMakerJobDetail, preOpenMarketRegularOthersSessionTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}