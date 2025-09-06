package rave.code.quartz.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEQuartzScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(BSEQuartzScheduler.class.toString());

    @Override
    public void scheduleJob() {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            new ScheduleJobsAt_8_45_AM_FromMondayToFriday(scheduler).scheduleJob();
            new ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With3MinuteFrequency(scheduler).scheduleJob();
            new ScheduleJobs_At_6_PM_From_Monday_To_Friday(scheduler).scheduleJob();

            scheduler.start();
            //scheduler.shutdown(true);
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }
    }

    public static void main(String[] args) {
        BSEQuartzScheduler bseQuartzScheduler = new BSEQuartzScheduler();
        bseQuartzScheduler.scheduleJob();
    }
}
