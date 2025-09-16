package rave.code.quartz.scheduler.nse;

import org.quartz.Scheduler;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Logger;

public class NSESpecialPreOpenSessionScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSESpecialPreOpenSessionScheduler.class.toString());

    public NSESpecialPreOpenSessionScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs(){} {
    }
}