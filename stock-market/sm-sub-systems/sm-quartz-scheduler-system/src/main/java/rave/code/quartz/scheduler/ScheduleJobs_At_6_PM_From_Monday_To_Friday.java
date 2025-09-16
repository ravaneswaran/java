package rave.code.quartz.scheduler;

import org.quartz.Scheduler;

import java.util.logging.Logger;

public class ScheduleJobs_At_6_PM_From_Monday_To_Friday extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ScheduleJobs_At_6_PM_From_Monday_To_Friday.class.toString());

    public ScheduleJobs_At_6_PM_From_Monday_To_Friday(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs(){} /*{

        JobDetail stockBaseJobDetail = newJob(NSESTock.class)
                .withIdentity(JobName.BSE_STOCK_BASE_JOB_NAME.get(), Group.STOCK_BASE.toString())
                .build();

        Trigger stockBaseJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_STOCK_BASE_TRIGGER_NAME.get(), Group.STOCK_BASE.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_6PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.STOCK_BASE.get())
                .build();

        try {
            this.scheduler.scheduleJob(stockBaseJobDetail, stockBaseJobTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }*/
}
