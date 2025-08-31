package rave.code.quartz.scheduler;

import org.quartz.*;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.job.moneycontrol.investing.BSEMidCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSESmallCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSETopDividendJob;
import rave.code.quartz.job.moneycontrol.misc.BSESensexJob;
import rave.code.quartz.job.moneycontrol.trading.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With5MinuteFrequency extends AbstractQuartzScheduler{

    public static final Logger LOGGER = Logger.getLogger(ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With3MinuteFrequency.class.toString());

    private Scheduler scheduler;

    public ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With5MinuteFrequency(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleJob() {
        new ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With5MinuteFrequency(this.scheduler).scheduleJob();
        new ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With5MinuteFrequency(this.scheduler).scheduleJob();
    }

    private class ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With5MinuteFrequency extends AbstractQuartzScheduler {

        public static final Logger LOGGER = Logger.getLogger(ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With5MinuteFrequency.class.toString());

        private Scheduler scheduler;

        public ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_10_AM_With5MinuteFrequency(Scheduler scheduler) {
            this.scheduler = scheduler;
        }

        @Override
        public void scheduleJob() {

            JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                    .withIdentity(JobName.BSE_ACTIVE_100_JOB_NAME.get(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                    .withIdentity(JobName.BSE_ACTIVE_200_JOB_NAME.get(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                    .withIdentity(JobName.BSE_ACTIVE_500_JOB_NAME.get(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bsePriceShockersJobDetail = newJob(BSEPriceShockersJob.class)
                    .withIdentity(JobName.BSE_PRICE_SHOCKERS_JOB_NAME.get(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseVolumeShockersJobDetail = newJob(BSEVolumeShockersJob.class)
                    .withIdentity(JobName.BSE_VOLUME_SHOCKERS_JOB_NAME.get(), Group.TRADING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                    .withIdentity(JobName.BSE_TOP_DIVIDEND_JOB_NAME.get(), Group.INVESTING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                    .withIdentity(JobName.BSE_MID_CAP_GAINER_JOB_NAME.get(), Group.INVESTING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                    .withIdentity(JobName.BSE_SMALL_CAP_GAINER_JOB_NAME.get(), Group.INVESTING_BATCH_1.toString()).storeDurably()
                    .build();
            JobDetail sensexJobDetail = newJob(BSESensexJob.class)
                    .withIdentity(JobName.BSE_SENSEX_JOB_NAME.get(), Group.MISCELLANEOUS_BATCH_1.toString())
                    .build();


            Trigger bseActive100JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_100_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_100.get())
                    .build();
            Trigger bseActive200JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_200_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_200.get())
                    .build();
            Trigger bseActive500JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_500_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_500.get())
                    .build();
            Trigger bsePriceShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_PRICE_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_PRICE_SHOCKER.get())
                    .build();
            Trigger bseVolumeShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_VOLUME_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_VOLUME_SHOCKER.get())
                    .build();
            Trigger bseTopDividendJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_TOP_DIVIDEND_TRIGGER_NAME.get(), Group.INVESTING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_TOP_DIVIDEND.get())
                    .build();
            Trigger bseMidCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_MID_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_MID_CAP_GAINER.get())
                    .build();
            Trigger bseSmallCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_SMALL_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_1.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_SMALL_CAP_GAINER.get())
                    .build();
            Trigger sensexJobTrigger = newTrigger()
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

    private class ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With5MinuteFrequency extends AbstractQuartzScheduler {

        public static final Logger LOGGER = Logger.getLogger(ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With5MinuteFrequency.class.toString());

        private Scheduler scheduler;

        public ScheduleJobsFromMondayToFridayBetween_10_AM_To_4_PM_With5MinuteFrequency(Scheduler scheduler) {
            this.scheduler = scheduler;
        }

        @Override
        public void scheduleJob() {

            JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                    .withIdentity(JobName.BSE_ACTIVE_100_JOB_NAME.get(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                    .withIdentity(JobName.BSE_ACTIVE_200_JOB_NAME.get(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                    .withIdentity(JobName.BSE_ACTIVE_500_JOB_NAME.get(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bsePriceShockersJobDetail = newJob(BSEPriceShockersJob.class)
                    .withIdentity(JobName.BSE_PRICE_SHOCKERS_JOB_NAME.get(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseVolumeShockersJobDetail = newJob(BSEVolumeShockersJob.class)
                    .withIdentity(JobName.BSE_VOLUME_SHOCKERS_JOB_NAME.get(), Group.TRADING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                    .withIdentity(JobName.BSE_TOP_DIVIDEND_JOB_NAME.get(), Group.INVESTING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                    .withIdentity(JobName.BSE_MID_CAP_GAINER_JOB_NAME.get(), Group.INVESTING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                    .withIdentity(JobName.BSE_SMALL_CAP_GAINER_JOB_NAME.get(), Group.INVESTING_BATCH_2.toString()).storeDurably()
                    .build();
            JobDetail sensexJobDetail = newJob(BSESensexJob.class)
                    .withIdentity(JobName.BSE_SENSEX_JOB_NAME.get(), Group.MISCELLANEOUS_BATCH_2.toString())
                    .build();


            Trigger bseActive100JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_100_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_100.get())
                    .build();
            Trigger bseActive200JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_200_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_200.get())
                    .build();
            Trigger bseActive500JobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_ACTIVE_500_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_500.get())
                    .build();
            Trigger bsePriceShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_PRICE_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_PRICE_SHOCKER.get())
                    .build();
            Trigger bseVolumeShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_VOLUME_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_VOLUME_SHOCKER.get())
                    .build();
            Trigger bseTopDividendJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_TOP_DIVIDEND_TRIGGER_NAME.get(), Group.INVESTING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_TOP_DIVIDEND.get())
                    .build();
            Trigger bseMidCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_MID_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_MID_CAP_GAINER.get())
                    .build();
            Trigger bseSmallCapGainerJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_SMALL_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING_BATCH_2.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM.toString()))
                    .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_SMALL_CAP_GAINER.get())
                    .build();
            Trigger sensexJobTrigger = newTrigger()
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
