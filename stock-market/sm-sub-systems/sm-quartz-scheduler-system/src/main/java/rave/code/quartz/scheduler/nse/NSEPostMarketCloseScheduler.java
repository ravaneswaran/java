package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.jobs.nse.csv.bhavcopy.NSEDayPriceDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.technical.NSEXXXMovingAverageDetailEntityMakerJob;
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
                .withIdentity(QuartzJob.NSE_POST_MARKET_CLOSE_BHAVCOPY_JOB.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName()).storeDurably()
                .build();

        /*JobDetail nseXXXMovingAverageEntityMakerJobDetail = newJob(NSEXXXMovingAverageDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_POST_MARKET_CLOSE_XXX_MOVING_AVERAGE_JOB.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName()).storeDurably()
                .build();*/

        /*JobDetail nsePriceToEarningRatioDetailEntityMakerJobDetail = newJob(NSEPriceToEarningRatioEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_POST_MARKET_CLOSE_PE_RATIO_JOB.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName()).storeDurably()
                .build();
        JobDetail nseXXXMovingAverageDetailEntityMakerJobDetail = newJob(NSEXXXMovingAverageDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_POST_MARKET_CLOSE_XXX_MOVING_AVERAGE_JOB.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName()).storeDurably()
                .build();*/

        Trigger nseDayPriceDetailEntityMakerJobTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_POST_MARKET_CLOSE_BHAVCOPY_TRIGGER.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_POST_MARKET_CLOSE_MONDAY_TO_FRIDAY_AT_05_00_PM.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_POST_MARKET_CLOSE.get())
                .build();

        /*Trigger nseXXXMovingAverageEntityMakerJobTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_POST_MARKET_CLOSE_XXX_MOVING_AVERAGE_TRIGGER.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_POST_MARKET_CLOSE_MONDAY_TO_FRIDAY_AT_05_05_PM.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_POST_MARKET_CLOSE.get())
                .build();*/

        /*Trigger nsePriceToEarningRatioDetailEntityMakerJobTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_POST_MARKET_CLOSE_PE_RATIO_TRIGGER.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_POST_MARKET_CLOSE_MONDAY_TO_FRIDAY_1.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_POST_MARKET_CLOSE.get())
                .build();
        Trigger nseXXXMovingAverageDetailEntityMakerJobTrigger = newTrigger()
                .withIdentity(QuartzTrigger.NSE_POST_MARKET_CLOSE_XXX_MOVING_AVERAGE_TRIGGER.getShortName(), QuartzGroup.NSE_POST_MARKET_CLOSE.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_POST_MARKET_CLOSE_MONDAY_TO_FRIDAY_2.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_POST_MARKET_CLOSE.get())
                .build();*/

        try {
            this.scheduler.scheduleJob(nseDayPriceDetailEntityMakerJobDetail, nseDayPriceDetailEntityMakerJobTrigger);
            /*this.scheduler.scheduleJob(nseXXXMovingAverageEntityMakerJobDetail, nseXXXMovingAverageEntityMakerJobTrigger);*/
            /*this.scheduler.scheduleJob(nsePriceToEarningRatioDetailEntityMakerJobDetail, nsePriceToEarningRatioDetailEntityMakerJobTrigger);
            this.scheduler.scheduleJob(nseXXXMovingAverageDetailEntityMakerJobDetail, nseXXXMovingAverageDetailEntityMakerJobTrigger);*/
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}
