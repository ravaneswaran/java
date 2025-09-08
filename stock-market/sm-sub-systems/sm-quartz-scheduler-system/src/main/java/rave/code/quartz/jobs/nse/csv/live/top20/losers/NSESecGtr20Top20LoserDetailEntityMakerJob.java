package rave.code.quartz.jobs.nse.csv.live.top20.losers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSESecGtr20Top20LoserDetailEntityMakerJob extends AbstractNSETop20LoserDetailEntityMakerJob{

    public NSESecGtr20Top20LoserDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=loosers&type=mae&key=SecGtr20&csv=true");
        super.setTop20SubType("SECURITY>20");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSESecGtr20Top20LoserDetailEntityMakerJob job = new NSESecGtr20Top20LoserDetailEntityMakerJob();
        job.saveTransformedData(job.transformSourceData(job.getDataFromSource()));
    }
}
