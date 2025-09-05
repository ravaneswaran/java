package rave.code.quartz.job.stockbase;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.jobs.AbstractQuartzJob;
import rave.code.quartz.jobs.bse.csv.bhavcopy.BSEDayPriceDetailEntityMakerJob;
import rave.code.utility.log.JavaUtilLogDecor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StockBase10EntityMakerJob extends AbstractQuartzJob {

    protected Date date;

    public StockBase10EntityMakerJob() {
        this(new Date());
    }

    public StockBase10EntityMakerJob(Date date) {
        this.date = date;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        new NSEStockBase10EntityMakerJob(this.date).execute(jobExecutionContext);
        new BSEDayPriceDetailEntityMakerJob(this.date).execute(jobExecutionContext);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(3);

        Date toDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date yesterDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

        StockBase10EntityMakerJob stockBaseJob = new StockBase10EntityMakerJob(yesterDate);
        stockBaseJob.execute(null);
    }
}


