package rave.code.quartz.scheduler;

import org.quartz.Scheduler;
import rave.code.quartz.scheduler.nse.NSEFirstBlockDealSessionScheduler;
import rave.code.quartz.scheduler.nse.NSELiveSessionScheduler;
import rave.code.quartz.scheduler.nse.NSEPostMarketCloseScheduler;
import rave.code.quartz.scheduler.nse.NSERegularPreOpenSessionScheduler;

import java.util.logging.Logger;

public class NSEQuartzScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(BSEQuartzScheduler.class.toString());

    public NSEQuartzScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs() {
        new NSEFirstBlockDealSessionScheduler(this.scheduler).scheduleJobs();
        new NSERegularPreOpenSessionScheduler(this.scheduler).scheduleJobs();
        new NSELiveSessionScheduler(this.scheduler).scheduleJobs();
        //new NSESecondBlockDealSessionScheduler(this.scheduler).scheduleJobs();
        new NSEPostMarketCloseScheduler(this.scheduler).scheduleJobs();
    }
}
