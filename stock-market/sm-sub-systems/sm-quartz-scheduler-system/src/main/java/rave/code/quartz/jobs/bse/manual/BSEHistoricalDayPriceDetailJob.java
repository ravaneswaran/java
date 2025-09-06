package rave.code.quartz.jobs.bse.manual;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.jobs.AbstractHistoricalDayPriceDetailJob;
import rave.code.quartz.jobs.bse.csv.bhavcopy.BSEDayPriceDetailEntityMakerJob;
import rave.code.repository.bse.BSEDayPriceDetailRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEHistoricalDayPriceDetailJob extends AbstractHistoricalDayPriceDetailJob {

    private static final Logger LOGGER = Logger.getLogger(BSEHistoricalDayPriceDetailJob.class.getName());

    private BSEDayPriceDetailRepository bseDayPriceDetailRepository = new BSEDayPriceDetailRepository();

    public BSEHistoricalDayPriceDetailJob() {
        this(1);
    }

    public BSEHistoricalDayPriceDetailJob(int noOfDaysInPast) {
        this.noOfDaysInPast = noOfDaysInPast;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.log(Level.FINE, "Deleting BSE day price detail repository...");
        this.bseDayPriceDetailRepository.deleteAll();
        List<Date> dates = this.getHistoricalDates(this.noOfDaysInPast);
        for (Date date : dates) {
            BSEDayPriceDetailEntityMakerJob bseDayPriceDetailEntityMakerJob = new BSEDayPriceDetailEntityMakerJob(date);
            bseDayPriceDetailEntityMakerJob.execute(jobExecutionContext);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        BSEHistoricalDayPriceDetailJob bseHistoricalDayPriceDetailJob = new BSEHistoricalDayPriceDetailJob(10);
        bseHistoricalDayPriceDetailJob.execute(null);
    }
}