package rave.code.nse.web;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;
import rave.code.data.model.web.HolidayDetailModel;
import rave.code.nse.web.properties.NSEQuartzOverrideProperties;
import rave.code.nse.web.service.NSEHolidayService;
import rave.code.quartz.scheduler.NSEQuartzScheduler;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class NSEQuartzLifeCycleComponent implements SmartLifecycle {

    private static final Logger LOGGER = Logger.getLogger(NSEQuartzLifeCycleComponent.class.getName());
    private Scheduler scheduler;
    private boolean running = false;
    private final NSEHolidayService nseHolidayService = new NSEHolidayService();

    public NSEQuartzLifeCycleComponent() {
        SchedulerFactory schedulerFactory = null;
        try {
            NSEQuartzOverrideProperties nseQuartzOverrideProperties = new NSEQuartzOverrideProperties();
            schedulerFactory = new StdSchedulerFactory(nseQuartzOverrideProperties);
        } catch (SchedulerException | IOException exception) {
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
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        List<HolidayDetailModel> holidayDetailModels = this.nseHolidayService.listHolidays();
        for (HolidayDetailModel holidayDetailModel : holidayDetailModels) {
            holidayCalendar.addExcludedDate(holidayDetailModel.getHolidate());
        }
        try {
            this.scheduler.addCalendar("NSECalendar", holidayCalendar, false, true);
        } catch (SchedulerException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }
        new NSEQuartzScheduler(this.scheduler).scheduleJobs();

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
