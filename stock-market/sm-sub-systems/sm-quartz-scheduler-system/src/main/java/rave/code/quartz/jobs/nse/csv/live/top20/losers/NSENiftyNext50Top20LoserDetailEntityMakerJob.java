package rave.code.quartz.jobs.nse.csv.live.top20.losers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSENiftyNext50Top20LoserDetailEntityMakerJob extends AbstractNSETop20LoserDetailEntityMakerJob {

    public NSENiftyNext50Top20LoserDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=loosers&type=mae&key=NIFTYNEXT50&csv=true");
        super.setTop20SubType("NIFTYNEXT50");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSENiftyNext50Top20LoserDetailEntityMakerJob job = new NSENiftyNext50Top20LoserDetailEntityMakerJob();
        job.saveTransformedData(job.transformSourceData(job.getDataFromSource()));
    }
}
