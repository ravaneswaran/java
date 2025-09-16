package rave.code.quartz.scheduler;

import org.quartz.Scheduler;
import rave.code.quartz.scheduler.nse.NSEFirstBlockDealSessionScheduler;
import rave.code.quartz.scheduler.nse.NSELiveSessionScheduler;
import rave.code.quartz.scheduler.nse.NSERegularPreOpenSessionScheduler;
import rave.code.quartz.scheduler.nse.NSESecondBlockDealSessionScheduler;

import java.util.logging.Logger;

public class BSEQuartzScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(BSEQuartzScheduler.class.toString());

    public BSEQuartzScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs() {
        System.out.println("scheduler ==================>>>>>>> " + this.scheduler);

        new ScheduleJobsAt_8_45_AM_FromMondayToFriday(this.scheduler).scheduleJobs();
        new ScheduleJobsFromMondayToFridayBetween_9_15_AM_To_4PM_With3MinuteFrequency(this.scheduler).scheduleJobs();
        new ScheduleJobs_At_6_PM_From_Monday_To_Friday(this.scheduler).scheduleJobs();

        new NSEFirstBlockDealSessionScheduler(this.scheduler).scheduleJobs();
        new NSERegularPreOpenSessionScheduler(this.scheduler).scheduleJobs();
        new NSELiveSessionScheduler(this.scheduler).scheduleJobs();
        new NSESecondBlockDealSessionScheduler(this.scheduler).scheduleJobs();
    }
}
