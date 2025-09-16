package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.Job;
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

        JobDetail nsePreOpenMarketNifty50EntityMakerJob = newJob(NSEPreOpenMarketNifty50EntityMakerJob.class)
                .withIdentity(Job.NSE_PRE_OPEN_REGULAR_SESSION.getName(), Group.PRE_OPEN_REGULAR_SESSION.name())
                .build();
        JobDetail nsePreOpenMarketBankNiftyEntityMakerJob = newJob(NSEPreOpenMarketBankNiftyEntityMakerJob.class)
                .withIdentity(Job.NSE_PRE_OPEN_REGULAR_SESSION.getName(), Group.PRE_OPEN_REGULAR_SESSION.name())
                .build();
        JobDetail nsePreOpenMarketSMEEntityMakerJob = newJob(NSEPreOpenMarketSMEEntityMakerJob.class)
                .withIdentity(Job.NSE_PRE_OPEN_REGULAR_SESSION.getName(), Group.PRE_OPEN_REGULAR_SESSION.name())
                .build();
        JobDetail nsePreOpenMarketFOEntityMakerJob = newJob(NSEPreOpenMarketFOEntityMakerJob.class)
                .withIdentity(Job.NSE_PRE_OPEN_REGULAR_SESSION.getName(), Group.PRE_OPEN_REGULAR_SESSION.name())
                .build();
        JobDetail nsePreOpenMarketOthersEntityMakerJob = newJob(NSEPreOpenMarketOthersEntityMakerJob.class)
                .withIdentity(Job.NSE_PRE_OPEN_REGULAR_SESSION.getName(), Group.PRE_OPEN_REGULAR_SESSION.name())
                .build();

        Trigger preOpenMarketRegularSessionTrigger = newTrigger()
                .withIdentity(TriggerName.NSE_PRE_OPEN_REGULAR_SESSION_TRIGGER.get(), Group.PRE_OPEN_REGULAR_SESSION.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_PRE_OPEN_SESSION_BETWEEN_09_00_TO_09_08_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.PRE_OPEN_MARKET_REGULAR_SESSION.get())
                .build();

        try {
            this.scheduler.scheduleJob(nsePreOpenMarketNifty50EntityMakerJob, preOpenMarketRegularSessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketBankNiftyEntityMakerJob, preOpenMarketRegularSessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketSMEEntityMakerJob, preOpenMarketRegularSessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketFOEntityMakerJob, preOpenMarketRegularSessionTrigger);
            this.scheduler.scheduleJob(nsePreOpenMarketOthersEntityMakerJob, preOpenMarketRegularSessionTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}