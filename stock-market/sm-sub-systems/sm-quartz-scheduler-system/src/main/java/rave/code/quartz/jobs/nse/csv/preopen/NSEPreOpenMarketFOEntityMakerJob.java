package rave.code.quartz.jobs.nse.csv.preopen;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketFOEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    public NSEPreOpenMarketFOEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=FO&csv=true");
        this.preOpenType = "FO";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketFOEntityMakerJob nsePreOpenMarketFOEntityMakerJob = new NSEPreOpenMarketFOEntityMakerJob();
        nsePreOpenMarketFOEntityMakerJob.saveTransformedData(nsePreOpenMarketFOEntityMakerJob.transformSourceData(nsePreOpenMarketFOEntityMakerJob.getDataFromSource()));
    }
}