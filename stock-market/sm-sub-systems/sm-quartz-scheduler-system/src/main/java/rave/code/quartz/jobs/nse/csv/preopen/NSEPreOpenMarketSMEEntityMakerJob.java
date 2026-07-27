package rave.code.quartz.jobs.nse.csv.preopen;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketSMEEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    public NSEPreOpenMarketSMEEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=SME&csv=true");
        this.preOpenType = "SME";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketSMEEntityMakerJob nsePreOpenMarketSMEEntityMakerJob = new NSEPreOpenMarketSMEEntityMakerJob();
        nsePreOpenMarketSMEEntityMakerJob.saveTransformedData(nsePreOpenMarketSMEEntityMakerJob.transformSourceData(nsePreOpenMarketSMEEntityMakerJob.getDataFromSource()));
    }
}