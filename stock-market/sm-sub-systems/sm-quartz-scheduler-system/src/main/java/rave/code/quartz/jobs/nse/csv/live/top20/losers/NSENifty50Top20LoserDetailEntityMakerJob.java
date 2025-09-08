package rave.code.quartz.jobs.nse.csv.live.top20.losers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSENifty50Top20LoserDetailEntityMakerJob extends AbstractNSETop20LoserDetailEntityMakerJob{

    public NSENifty50Top20LoserDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=loosers&type=mae&key=NIFTY&csv=true");
        super.setTop20SubType("NIFTY50");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSENifty50Top20LoserDetailEntityMakerJob job = new NSENifty50Top20LoserDetailEntityMakerJob();
        job.saveTransformedData(job.transformSourceData(job.getDataFromSource()));
    }
}
