package rave.code.bse.web;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rave.code.quartz.scheduler.BSEQuartzScheduler;

@Configuration
public class BSEQuartzSchedulerConfiguration {

    @Bean
    public int scheduleBSEJobs() {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            System.out.println("-------------------->>>>>>>>> "+scheduler);

            new BSEQuartzScheduler(scheduler).scheduleJobs();
            scheduler.start();
        } catch (SchedulerException exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
