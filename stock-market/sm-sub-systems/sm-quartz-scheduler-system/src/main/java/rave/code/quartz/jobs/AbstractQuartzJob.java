package rave.code.quartz.jobs;

import org.hibernate.dialect.pagination.LegacyOracleLimitHandler;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.process.AbstractSubProcess;
import rave.code.process.SubProcess;
import rave.code.utility.log.message.JavaUtilLogMessage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Logger;

public abstract class AbstractQuartzJob extends AbstractSubProcess implements Job {

    @Override
    public SubProcess action() throws IOException {
        return null;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date startTime = new Date();
        this.executeJob(context);
        Date endTime = new Date();
        this.getLogger().info(this.printJobStat(startTime, endTime));
    }

    private String printJobStat(Date startTime, Date endTime) {
        Duration duration = Duration.between(startTime.toInstant(), endTime.toInstant());
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.toSeconds();
        String jobStatString = "\n" + "Job Name >>> " + this.getJobName() + "\n" +
                "Start Time >>> " + this.getDetailedTime(startTime) + "\n" +
                "End Time >>> " + this.getDetailedTime(endTime) + "\n" +
                "Time Taken >>> " + String.format("%s hours : %s minutes : %s seconds ", hours, minutes, seconds) + "\n";

        JavaUtilLogMessage javaUtilLogMessage = new JavaUtilLogMessage(jobStatString);
        return javaUtilLogMessage.getDecoratedLogMessage();
    }

    public void executeJob(JobExecutionContext context) throws JobExecutionException {
    }

    public String getJobName() {
        return this.getClass().getName();
    }

    public String getDetailedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }
}
