package rave.code.quartz.jobs.nse.csv.preopen;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketOthersEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    public NSEPreOpenMarketOthersEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=OTHERS&csv=true");
        this.preOpenType = "OTHERS";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketOthersEntityMakerJob nsePreOpenMarketOthersEntityMakerJob = new NSEPreOpenMarketOthersEntityMakerJob();
        nsePreOpenMarketOthersEntityMakerJob.saveTransformedData(nsePreOpenMarketOthersEntityMakerJob.transformSourceData(nsePreOpenMarketOthersEntityMakerJob.getDataFromSource()));
    }
}