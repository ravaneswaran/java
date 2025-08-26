package rave.code.quartz.job.moneycontrol;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.quartz.job.AbstractWebSiteEntityMakerJob;

import java.util.List;

public abstract class AbstractMoneyControlEntityMakerJob<S, T> extends AbstractWebSiteEntityMakerJob<S, T> {}