package rave.code.quartz.jobs.nse.csv.live.top20.losers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEFuturesAndOptionTop20LoserDetailEntityMakerJob extends AbstractNSETop20LoserDetailEntityMakerJob{

    public NSEFuturesAndOptionTop20LoserDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=loosers&type=mae&key=FOSec&csv=true");
        super.setTop20SubType("FOSecurity");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEFuturesAndOptionTop20LoserDetailEntityMakerJob job = new NSEFuturesAndOptionTop20LoserDetailEntityMakerJob();
        job.saveTransformedData(job.transformSourceData(job.getDataFromSource()));
    }
}
