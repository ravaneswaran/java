package rave.code.quartz.jobs.nse.csv.live.top20.losers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEBankNiftyTop20LoserDetailEntityMakerJob extends AbstractNSETop20LoserDetailEntityMakerJob {

    public NSEBankNiftyTop20LoserDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=loosers&type=mae&key=BANKNIFTY&csv=true");
        super.setTop20SubType("BANKNIFTY");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEBankNiftyTop20LoserDetailEntityMakerJob job = new NSEBankNiftyTop20LoserDetailEntityMakerJob();
        job.saveTransformedData(job.transformSourceData(job.getDataFromSource()));
    }
}
