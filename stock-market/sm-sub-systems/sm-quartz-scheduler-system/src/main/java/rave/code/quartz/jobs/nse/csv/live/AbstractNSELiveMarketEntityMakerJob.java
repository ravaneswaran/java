package rave.code.quartz.jobs.nse.csv.live;

import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;

public abstract class AbstractNSELiveMarketEntityMakerJob<T> extends AbstractNSECSVEntityMakerJob<T> {

    public AbstractNSELiveMarketEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
        super.setDownloadPageUrl("https://www.nseindia.com/market-data/most-active-equities");
    }
}
