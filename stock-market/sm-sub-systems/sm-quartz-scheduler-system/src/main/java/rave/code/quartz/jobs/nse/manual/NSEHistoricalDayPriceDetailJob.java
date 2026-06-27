package rave.code.quartz.jobs.nse.manual;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.jobs.AbstractHistoricalDayPriceDetailJob;
import rave.code.quartz.jobs.nse.csv.bhavcopy.NSEDayPriceDetailEntityMakerJob;
import rave.code.repository.nse.NSEDayPriceDetailRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEHistoricalDayPriceDetailJob extends AbstractHistoricalDayPriceDetailJob {

    private static final Logger LOGGER = Logger.getLogger(NSEHistoricalDayPriceDetailJob.class.getName());

    private NSEDayPriceDetailRepository nseDayPriceDetailRepository = new NSEDayPriceDetailRepository();

    public NSEHistoricalDayPriceDetailJob(){
        this(1);
    }

    public NSEHistoricalDayPriceDetailJob(int noOfDaysInPast){
        this.noOfDaysInPast = noOfDaysInPast;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.log(Level.FINE, "Deleting NSE day price detail repository...");
        this.nseDayPriceDetailRepository.deleteAll();
        List<Date> dates = this.getHistoricalDates(this.noOfDaysInPast);
        for (Date date: dates){
            NSEDayPriceDetailEntityMakerJob nseDayPriceDetailEntityMakerJob = new NSEDayPriceDetailEntityMakerJob(date);
            nseDayPriceDetailEntityMakerJob.execute(jobExecutionContext);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSEHistoricalDayPriceDetailJob nseHistoricalDayPriceDetailJob = new NSEHistoricalDayPriceDetailJob(365);
        nseHistoricalDayPriceDetailJob.execute(null);
    }
}