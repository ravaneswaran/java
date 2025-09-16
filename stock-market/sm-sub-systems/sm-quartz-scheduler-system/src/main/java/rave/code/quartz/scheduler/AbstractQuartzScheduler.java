package rave.code.quartz.scheduler;

import org.quartz.Scheduler;

public abstract class AbstractQuartzScheduler {

    protected Scheduler scheduler;

    public abstract void scheduleJobs();

    public AbstractQuartzScheduler(Scheduler scheduler){
        this.scheduler = scheduler;
    }

}
