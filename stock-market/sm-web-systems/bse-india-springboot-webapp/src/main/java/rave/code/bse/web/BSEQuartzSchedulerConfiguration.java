package rave.code.bse.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rave.code.quartz.scheduler.BSEQuartzScheduler;

@Configuration
public class BSEQuartzSchedulerConfiguration {

    @Bean
    public int scheduleJobs() {
        new BSEQuartzScheduler().scheduleJob();
        return 0;
    }
}
