package rave.code.quartz.job.history;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;

public abstract class AbstractHistoryEntityMakerJob<S, T> extends AbstractQuartzJob {

    public abstract void loadHistoryAndClearSource();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.loadHistoryAndClearSource();
    }
}
