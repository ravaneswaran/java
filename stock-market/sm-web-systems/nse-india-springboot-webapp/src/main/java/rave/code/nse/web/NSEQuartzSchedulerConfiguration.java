package rave.code.nse.web;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rave.code.nse.web.model.HolidayDetailModel;
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
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            HolidayCalendar holidayCalendar = new HolidayCalendar();
            List<HolidayDetailModel> holidayDetailModels = this.nseHolidayService.listHolidays();
            for (HolidayDetailModel holidayDetailModel : holidayDetailModels) {
                holidayCalendar.addExcludedDate(holidayDetailModel.getHolidate());
            }
            scheduler.addCalendar("NSECalendar", holidayCalendar, false, true);
            new NSEQuartzScheduler(scheduler).scheduleJobs();
            scheduler.start();
        } catch (SchedulerException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
        }

        return 0;
    }
}
