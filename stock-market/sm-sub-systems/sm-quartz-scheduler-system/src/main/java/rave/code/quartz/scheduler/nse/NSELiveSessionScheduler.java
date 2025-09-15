package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.Job;
import rave.code.quartz.jobs.nse.csv.live.etf.NSEExchangeTradedFundDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.mainboard.NSEMainBoardDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.sme.NSESMEDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.spurts.NSEPriceSpurtSPGtr20DetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.spurts.NSEPriceSpurtSPLwr20DetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.spurts.NSEVolumeSpurtsDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.top20.gainers.*;
import rave.code.quartz.jobs.nse.csv.live.top20.gainers.NSESecLwr20Top20GainerDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.top20.losers.*;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSELiveSessionScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSELiveSessionScheduler.class.toString());

    private Scheduler scheduler;

    public NSELiveSessionScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleJob(){} {

        JobDetail nseExchangeTradedFundDetailEntityMakerJob = newJob(NSEExchangeTradedFundDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseMainBoardDetailEntityMakerJob = newJob(NSEMainBoardDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseSMEDetailEntityMakerJob = newJob(NSESMEDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nsePriceSpurtSPGtr20DetailEntityMakerJob = newJob(NSEPriceSpurtSPGtr20DetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nsePriceSpurtSPLwr20DetailEntityMakerJob = newJob(NSEPriceSpurtSPLwr20DetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseVolumeSpurtsDetailEntityMakerJob = newJob(NSEVolumeSpurtsDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseBankNiftyTop20GainerDetailEntityMakerJob = newJob(NSEBankNiftyTop20GainerDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseFuturesAndOptionTop20GainerDetailEntityMakerJob = newJob(NSEFuturesAndOptionTop20GainerDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseNifty50Top20GainerDetailEntityMakerJob = newJob(NSENifty50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseNiftyNext50Top20GainerDetailEntityMakerJob = newJob(NSENiftyNext50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseSecGtr20Top20GainerDetailEntityMakerJob = newJob(NSESecGtr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseSecLwr20Top20GainerDetailEntityMakerJob = newJob(NSESecLwr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseBankNiftyTop20LoserDetailEntityMakerJob = newJob(NSEBankNiftyTop20LoserDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseFuturesAndOptionTop20LoserDetailEntityMakerJob = newJob(NSEFuturesAndOptionTop20LoserDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseNifty50Top20LoserDetailEntityMakerJob = newJob(NSENifty50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseNiftyNext50Top20LoserDetailEntityMakerJob = newJob(NSENiftyNext50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseSecGtr20Top20LoserDetailEntityMakerJob = newJob(NSESecGtr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();
        JobDetail nseSecLwr20Top20LoserDetailEntityMakerJob = newJob(NSESecLwr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(Job.NSE_T_PLUS_0_LIVE_SESSION.getName(), Group.LIVE_SESSION.name())
                .build();

        Trigger triggerOne = newTrigger()
                .withIdentity(TriggerName.NSE_T_PLUS_0_LIVE_SESSION_TRIGGER.get(), Group.LIVE_SESSION.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.T_PLUS_0_LIVE_SESSION.get())
                .build();
        Trigger triggerTwo = newTrigger()
                .withIdentity(TriggerName.NSE_T_PLUS_0_LIVE_SESSION_TRIGGER.get(), Group.LIVE_SESSION.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.T_PLUS_0_LIVE_SESSION.get())
                .build();
        Trigger triggerThree = newTrigger()
                .withIdentity(TriggerName.NSE_T_PLUS_0_LIVE_SESSION_TRIGGER.get(), Group.LIVE_SESSION.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.T_PLUS_0_LIVE_SESSION.get())
                .build();


        try {

            this.scheduler.scheduleJob(nseExchangeTradedFundDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseExchangeTradedFundDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseExchangeTradedFundDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseMainBoardDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseMainBoardDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseMainBoardDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseSMEDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseSMEDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseSMEDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nsePriceSpurtSPGtr20DetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nsePriceSpurtSPGtr20DetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nsePriceSpurtSPGtr20DetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nsePriceSpurtSPLwr20DetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nsePriceSpurtSPLwr20DetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nsePriceSpurtSPLwr20DetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseVolumeSpurtsDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseVolumeSpurtsDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseVolumeSpurtsDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseBankNiftyTop20GainerDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseBankNiftyTop20GainerDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseBankNiftyTop20GainerDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseFuturesAndOptionTop20GainerDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20GainerDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20GainerDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseNifty50Top20GainerDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseNifty50Top20GainerDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseNifty50Top20GainerDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseNiftyNext50Top20GainerDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseNiftyNext50Top20GainerDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseNiftyNext50Top20GainerDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseSecGtr20Top20GainerDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseSecGtr20Top20GainerDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseSecGtr20Top20GainerDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseSecLwr20Top20GainerDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseSecLwr20Top20GainerDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseSecLwr20Top20GainerDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseBankNiftyTop20LoserDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseBankNiftyTop20LoserDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseBankNiftyTop20LoserDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseFuturesAndOptionTop20LoserDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20LoserDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20LoserDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseNifty50Top20LoserDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseNifty50Top20LoserDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseNifty50Top20LoserDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseNiftyNext50Top20LoserDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseNiftyNext50Top20LoserDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseNiftyNext50Top20LoserDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseSecGtr20Top20LoserDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseSecGtr20Top20LoserDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseSecGtr20Top20LoserDetailEntityMakerJob, triggerThree);

            this.scheduler.scheduleJob(nseSecLwr20Top20LoserDetailEntityMakerJob, triggerOne);
            this.scheduler.scheduleJob(nseSecLwr20Top20LoserDetailEntityMakerJob, triggerTwo);
            this.scheduler.scheduleJob(nseSecLwr20Top20LoserDetailEntityMakerJob, triggerThree);

        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}