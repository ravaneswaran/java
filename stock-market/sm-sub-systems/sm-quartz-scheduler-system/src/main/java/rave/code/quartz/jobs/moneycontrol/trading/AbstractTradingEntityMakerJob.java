package rave.code.quartz.jobs.moneycontrol.trading;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.jobs.moneycontrol.AbstractMoneyControlEntityMakerJob;

import java.util.List;

public abstract class AbstractTradingEntityMakerJob<S, T> extends AbstractMoneyControlEntityMakerJob<S, T> {

    public abstract List<S> getDataFromSource();

    public abstract List<T> transformSourceData(List<S> sourceData);

    public abstract void saveTransformedData(List<T> transformedData);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<S> sourceData = this.getDataFromSource();
        List<T> transformedData = this.transformSourceData(sourceData);
        saveTransformedData(transformedData);
    }
}