package rave.code.entity.quartz.job.history;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.entity.quartz.job.AbstractQuartzJob;

public abstract class AbstractHistoryEntityMakerJob<S, T> extends AbstractQuartzJob {

    public abstract void loadHistoryAndClearSource();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.loadHistoryAndClearSource();
    }
}
