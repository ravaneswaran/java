package rave.code.nse.web;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rave.code.quartz.scheduler.NSEQuartzScheduler;

@Configuration
public class NSEQuartzSchedulerConfiguration {

    @Bean
    public int scheduleNSEJobs() {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            new NSEQuartzScheduler(scheduler).scheduleJobs();
            scheduler.start();
        } catch (SchedulerException exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
