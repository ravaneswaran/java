package rave.code.quartz.job.stockbase;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.jobs.AbstractQuartzJob;

public abstract class AbstractEntityMakerJob<S, T> extends AbstractQuartzJob {

    public abstract S getDataFromSource();

    public abstract T transformSourceData(S sourceData);

    public abstract void saveTransformedData(T transformedData);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        S sourceData = this.getDataFromSource();
        T transformedData = this.transformSourceData(sourceData);
        saveTransformedData(transformedData);
    }
}
