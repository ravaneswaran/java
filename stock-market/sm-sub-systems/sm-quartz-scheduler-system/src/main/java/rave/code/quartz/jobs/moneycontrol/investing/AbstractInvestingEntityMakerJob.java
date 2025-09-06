package rave.code.quartz.jobs.moneycontrol.investing;

import rave.code.quartz.jobs.moneycontrol.AbstractMoneyControlEntityMakerJob;

import java.util.List;

public abstract class AbstractInvestingEntityMakerJob<S, T> extends AbstractMoneyControlEntityMakerJob<S, T> {

    public abstract List<S> getDataFromSource();

    public abstract List<T> transformSourceData(List<S> sourceData);

    public abstract void saveTransformedData(List<T> transformedData);
}