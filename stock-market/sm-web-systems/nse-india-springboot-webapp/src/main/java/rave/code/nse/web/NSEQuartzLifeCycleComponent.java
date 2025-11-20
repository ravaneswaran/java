package rave.code.nse.web;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;
import rave.code.nse.web.properties.NSEQuartzOverrideProperties;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class NSEQuartzLifeCycleComponent implements SmartLifecycle {

    private static final Logger LOGGER = Logger.getLogger(NSEQuartzLifeCycleComponent.class.getName());

    private Scheduler scheduler;
    private boolean running = false;

    public NSEQuartzLifeCycleComponent() {
        SchedulerFactory schedulerFactory = null;
        try {
            schedulerFactory = new StdSchedulerFactory(new NSEQuartzOverrideProperties());
        } catch (SchedulerException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }

        if (null != schedulerFactory) {
            try {
                this.scheduler = schedulerFactory.getScheduler();
            } catch (SchedulerException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            }
        }
    }

    @Override
    public void start() {
        try {
            this.scheduler.start();
            this.running = true;
            LOGGER.info("***** NSE Quartz Scheduler started... *****");
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public void stop() {
        try {
            this.scheduler.shutdown(true); // wait for jobs to complete
            this.running = false;
            LOGGER.info("***** NSE Quartz Scheduler stopped... *****");
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE; // start last, stop first
    }
}
