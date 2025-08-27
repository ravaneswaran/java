package rave.code.quartz.job.stockbase;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.utility.log.JavaUtilLogDecor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StockBaseEntityMakerJob extends AbstractQuartzJob {

    protected Date date;

    public StockBaseEntityMakerJob() {
        this(new Date());
    }

    public StockBaseEntityMakerJob(Date date) {
        this.date = date;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        new NSEStockBaseEntityMakerJob(this.date).execute(jobExecutionContext);
        //new BSEStockBaseEntityMakerJob(this.date).execute(jobExecutionContext);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(3);

        Date toDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date yesterDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

        StockBaseEntityMakerJob stockBaseJob = new StockBaseEntityMakerJob(yesterDate);
        stockBaseJob.execute(null);
    }
}


