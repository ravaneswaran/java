package rave.code.quartz.scheduler;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.QuartzJob;
import rave.code.quartz.enums.QuartzTrigger;
import rave.code.quartz.jobs.history.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ScheduleJobsAt_8_45_AM_FromMondayToFriday extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ScheduleJobsAt_8_45_AM_FromMondayToFriday.class.toString());

    public ScheduleJobsAt_8_45_AM_FromMondayToFriday(Scheduler scheduler) {
        super(scheduler);
        System.out.println("============= "+this.scheduler);
    }

    @Override
    public void scheduleJobs() {

        JobDetail bseActive100HistoryJobDetail = newJob(BSEActive100HistoryJob.class)
                .withIdentity(QuartzJob.BSE_ACTIVE_100_HISTORY_JOB_NAME.getName(), QuartzGroup.HISTORY.toString())
                .build();
        JobDetail bseActive200HistoryJobDetail = newJob(BSEActive200HistoryJob.class)
                .withIdentity(QuartzJob.BSE_ACTIVE_200_HISTORY_JOB_NAME.getName(), QuartzGroup.HISTORY.toString())
                .build();
        JobDetail bseActive500HistoryJobDetail = newJob(BSEActive500HistoryJob.class)
                .withIdentity(QuartzJob.BSE_ACTIVE_500_HISTORY_JOB_NAME.getName(), QuartzGroup.HISTORY.toString())
                .build();
        JobDetail bsePriceShockerHistoryJobDetail = newJob(BSEPriceShockersHistoryJob.class)
                .withIdentity(QuartzJob.BSE_ACTIVE_PRICE_SHOCKER_HISTORY_JOB_NAME.getName(), QuartzGroup.HISTORY.toString())
                .build();
        JobDetail bseVolumeShockerHistoryJobDetail = newJob(BSEVolumeShockersHistoryJob.class)
                .withIdentity(QuartzJob.BSE_ACTIVE_VOLUME_SHOCKER_HISTORY_JOB_NAME.getName(), QuartzGroup.HISTORY.toString())
                .build();

        org.quartz.Trigger bseActive100HistoryJobDetailTrigger = newTrigger()
                .withIdentity(QuartzTrigger.BSE_ACTIVE_100_HISTORY_TRIGGER_NAME.get(), QuartzGroup.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_BLOCK_DEAL_FIRST_SESSION_BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_100_HISTORY.get())
                .build();
        org.quartz.Trigger bseActive200HistoryJobDetailTrigger = newTrigger()
                .withIdentity(QuartzTrigger.BSE_ACTIVE_200_HISTORY_TRIGGER_NAME.get(), QuartzGroup.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_BLOCK_DEAL_FIRST_SESSION_BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_200_HISTORY.get())
                .build();
        org.quartz.Trigger bseActive500HistoryJobDetailTrigger = newTrigger()
                .withIdentity(QuartzTrigger.BSE_ACTIVE_500_HISTORY_TRIGGER_NAME.get(), QuartzGroup.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_BLOCK_DEAL_FIRST_SESSION_BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_500_HISTORY.get())
                .build();
        org.quartz.Trigger bsePriceShockerHistoryJobDetailTrigger = newTrigger()
                .withIdentity(QuartzTrigger.BSE_PRICE_SHOCKER_HISTORY_TRIGGER_NAME.get(), QuartzGroup.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_BLOCK_DEAL_FIRST_SESSION_BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_PRICE_SHOCKER_HISTORY.get())
                .build();
        org.quartz.Trigger bseVolumeShockerHistoryJobDetailTrigger = newTrigger()
                .withIdentity(QuartzTrigger.BSE_VOLUME_SHOCKER_HISTORY_TRIGGER_NAME.get(), QuartzGroup.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_BLOCK_DEAL_FIRST_SESSION_BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_VOLUME_SHOCKER_HISTORY.get())
                .build();

        try {
            this.scheduler.scheduleJob(bseActive100HistoryJobDetail, bseActive100HistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bseActive200HistoryJobDetail, bseActive200HistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bseActive500HistoryJobDetail, bseActive500HistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bsePriceShockerHistoryJobDetail, bsePriceShockerHistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bseVolumeShockerHistoryJobDetail, bseVolumeShockerHistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}
