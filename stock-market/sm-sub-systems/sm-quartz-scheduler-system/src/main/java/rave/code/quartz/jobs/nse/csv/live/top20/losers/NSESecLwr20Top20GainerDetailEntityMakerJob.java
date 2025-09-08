package rave.code.quartz.jobs.nse.csv.live.top20.losers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSESecLwr20Top20GainerDetailEntityMakerJob extends AbstractNSETop20LoserDetailEntityMakerJob{

    public NSESecLwr20Top20GainerDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=loosers&type=mae&key=SecLwr20&csv=true");
        super.setTop20SubType("SECURITY<20");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSESecLwr20Top20GainerDetailEntityMakerJob job = new NSESecLwr20Top20GainerDetailEntityMakerJob();
        job.saveTransformedData(job.transformSourceData(job.getDataFromSource()));
    }
}
