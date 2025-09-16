package rave.code.quartz.scheduler;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.Job;
import rave.code.quartz.enums.TriggerName;
import rave.code.quartz.jobs.moneycontrol.investing.BSEMidCapGainerJob;
import rave.code.quartz.jobs.moneycontrol.investing.BSESmallCapGainerJob;
import rave.code.quartz.jobs.moneycontrol.investing.BSETopDividendJob;
import rave.code.quartz.jobs.moneycontrol.misc.BSESensexJob;
import rave.code.quartz.jobs.moneycontrol.trading.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With3MinuteFrequency extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With3MinuteFrequency.class.toString());

    public ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With3MinuteFrequency(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs() {
        new ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With3MinuteFrequency(this.scheduler).scheduleJobs();
        new ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With3MinuteFrequency(this.scheduler).scheduleJobs();
    }

    private class ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With3MinuteFrequency extends AbstractQuartzScheduler {

        public static final Logger LOGGER = Logger.getLogger(ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With3MinuteFrequency.class.toString());

        public ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With3MinuteFrequency(Scheduler scheduler) {
            super(scheduler);
        }

        @Override
        public void scheduleJobs() {

            JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                    .withIdentity(Job.BSE_ACTIVE_100_JOB_NAME.getName(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                    .withIdentity(Job.BSE_ACTIVE_200_JOB_NAME.getName(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                    .withIdentity(Job.BSE_ACTIVE_500_JOB_NAME.getName(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bsePriceShockersJobDetail = newJob(BSEPriceShockersJob.class)
                    .withIdentity(Job.BSE_PRICE_SHOCKERS_JOB_NAME.getName(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseVolumeShockersJobDetail = newJob(BSEVolumeShockersJob.class)
                    .withIdentity(Job.BSE_VOLUME_SHOCKERS_JOB_NAME.getName(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                    .withIdentity(Job.BSE_TOP_DIVIDEND_JOB_NAME.getName(), Group.INVESTING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                    .withIdentity(Job.BSE_MID_CAP_GAINER_JOB_NAME.getName(), Group.INVESTING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                    .withIdentity(Job.BSE_SMALL_CAP_GAINER_JOB_NAME.getName(), Group.INVESTING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail sensexJobDetail = newJob(BSESensexJob.class)
                    .withIdentity(Job.BSE_SENSEX_JOB_NAME.getName(), Group.MISCELLANEOUS_BATCH_1.toString())
                    .build();


            org.quartz.Trigger bseActive100JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_100_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_100.get())
                    .build();
            org.quartz.Trigger bseActive200JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_200_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_200.get())
                    .build();
            org.quartz.Trigger bseActive500JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_500_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_500.get())
                    .build();
            org.quartz.Trigger bsePriceShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_PRICE_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_PRICE_SHOCKER.get())
                    .build();
            org.quartz.Trigger bseVolumeShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_VOLUME_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_VOLUME_SHOCKER.get())
                    .build();
            org.quartz.Trigger bseTopDividendJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_TOP_DIVIDEND_TRIGGER_NAME.get(), Group.INVESTING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_TOP_DIVIDEND.get())
                    .build();
            org.quartz.Trigger bseMidCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_MID_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_MID_CAP_GAINER.get())
                    .build();
            org.quartz.Trigger bseSmallCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_SMALL_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_SMALL_CAP_GAINER.get())
                    .build();
            org.quartz.Trigger sensexJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_SENSEX_TRIGGER_NAME.get(), Group.MISCELLANEOUS_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.SENSEX.get())
                    .build();

            try {
                this.scheduler.scheduleJob(bseActive100JobDetail, bseActive100JobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseActive200JobDetail, bseActive200JobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseActive500JobDetail, bseActive500JobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bsePriceShockersJobDetail, bsePriceShockersJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseVolumeShockersJobDetail, bseVolumeShockersJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseTopDividendJob, bseTopDividendJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseMidCapGainerJob, bseMidCapGainerJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseSmallCapGainerJob, bseSmallCapGainerJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(sensexJobDetail, sensexJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
        }
    }

    private class ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With3MinuteFrequency extends AbstractQuartzScheduler {

        public static final Logger LOGGER = Logger.getLogger(ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With3MinuteFrequency.class.toString());

        public ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With3MinuteFrequency(Scheduler scheduler) {
            super(scheduler);
        }

        @Override
        public void scheduleJobs() {

            JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                    .withIdentity(Job.BSE_ACTIVE_100_JOB_NAME.getName(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                    .withIdentity(Job.BSE_ACTIVE_200_JOB_NAME.getName(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                    .withIdentity(Job.BSE_ACTIVE_500_JOB_NAME.getName(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bsePriceShockersJobDetail = newJob(BSEPriceShockersJob.class)
                    .withIdentity(Job.BSE_PRICE_SHOCKERS_JOB_NAME.getName(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseVolumeShockersJobDetail = newJob(BSEVolumeShockersJob.class)
                    .withIdentity(Job.BSE_VOLUME_SHOCKERS_JOB_NAME.getName(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                    .withIdentity(Job.BSE_TOP_DIVIDEND_JOB_NAME.getName(), Group.INVESTING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                    .withIdentity(Job.BSE_MID_CAP_GAINER_JOB_NAME.getName(), Group.INVESTING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                    .withIdentity(Job.BSE_SMALL_CAP_GAINER_JOB_NAME.getName(), Group.INVESTING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail sensexJobDetail = newJob(BSESensexJob.class)
                    .withIdentity(Job.BSE_SENSEX_JOB_NAME.getName(), Group.MISCELLANEOUS_BATCH_2.toString())
                    .build();


            org.quartz.Trigger bseActive100JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_100_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_100.get())
                    .build();
            org.quartz.Trigger bseActive200JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_200_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_200.get())
                    .build();
            org.quartz.Trigger bseActive500JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_500_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_500.get())
                    .build();
            org.quartz.Trigger bsePriceShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_PRICE_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_PRICE_SHOCKER.get())
                    .build();
            org.quartz.Trigger bseVolumeShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_VOLUME_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_VOLUME_SHOCKER.get())
                    .build();
            org.quartz.Trigger bseTopDividendJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_TOP_DIVIDEND_TRIGGER_NAME.get(), Group.INVESTING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_TOP_DIVIDEND.get())
                    .build();
            org.quartz.Trigger bseMidCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_MID_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_MID_CAP_GAINER.get())
                    .build();
            org.quartz.Trigger bseSmallCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_SMALL_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_SMALL_CAP_GAINER.get())
                    .build();
            org.quartz.Trigger sensexJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_SENSEX_TRIGGER_NAME.get(), Group.MISCELLANEOUS_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.SENSEX.get())
                    .build();

            try {
                this.scheduler.scheduleJob(bseActive100JobDetail, bseActive100JobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseActive200JobDetail, bseActive200JobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseActive500JobDetail, bseActive500JobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bsePriceShockersJobDetail, bsePriceShockersJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseVolumeShockersJobDetail, bseVolumeShockersJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseTopDividendJob, bseTopDividendJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseMidCapGainerJob, bseMidCapGainerJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(bseSmallCapGainerJob, bseSmallCapGainerJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
            try {
                this.scheduler.scheduleJob(sensexJobDetail, sensexJobTrigger);
            } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
                LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
            } catch (SchedulerException schedulerException) {
                LOGGER.log(Level.SEVERE, schedulerException.getMessage());
            }
        }
    }
}
