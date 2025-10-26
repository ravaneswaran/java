package rave.code.nse.web;

import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rave.code.data.model.web.HolidayDetailModel;
import rave.code.nse.web.service.NSEHolidayService;
import rave.code.quartz.scheduler.NSEQuartzScheduler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class NSEQuartzSchedulerConfiguration {

    private static final Logger LOGGER = Logger.getLogger(NSEQuartzSchedulerConfiguration.class.getName());

    @Autowired
    private NSEHolidayService nseHolidayService;

    @Bean
    public int scheduleNSEJobs() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        List<HolidayDetailModel> holidayDetailModels = this.nseHolidayService.listHolidays();
        for (HolidayDetailModel holidayDetailModel : holidayDetailModels) {
            holidayCalendar.addExcludedDate(holidayDetailModel.getHolidate());
        }
        try {
            scheduler.addCalendar("NSECalendar", holidayCalendar, false, true);
        } catch (ObjectAlreadyExistsException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        } catch (SchedulerException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }
        new NSEQuartzScheduler(scheduler).scheduleJobs();
        try {
            scheduler.start();
        } catch (SchedulerException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }

        return 0;
    }
}
