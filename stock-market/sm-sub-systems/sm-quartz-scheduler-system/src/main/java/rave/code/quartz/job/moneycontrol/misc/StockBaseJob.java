package rave.code.quartz.job.moneycontrol.misc;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.utility.log.JavaUtilLogDecor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StockBaseJob extends AbstractQuartzJob {

    protected Date date;

    public StockBaseJob() {
        this(new Date());
    }

    public StockBaseJob(Date date) {
        this.date = date;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        new NSEStockBaseJob(this.date).execute(jobExecutionContext);
        new BSEStockBaseJob(this.date).execute(jobExecutionContext);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(3);

        Date toDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date yesterDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

        StockBaseJob stockBaseJob = new StockBaseJob(yesterDate);
        stockBaseJob.execute(null);
    }
}


