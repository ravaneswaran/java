package rave.code.quartz.jobs.nse.csv.live.top20.gainers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSENifty50Top20GainerDetailEntityMakerJob extends AbstractNSETop20GainerDetailEntityMakerJob{

    public NSENifty50Top20GainerDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=NIFTY&csv=true");
        super.setTop20SubType("NIFTY50");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSENifty50Top20GainerDetailEntityMakerJob nseNifty50Top20GainerDetailEntityMakerJob = new NSENifty50Top20GainerDetailEntityMakerJob();
        nseNifty50Top20GainerDetailEntityMakerJob.saveTransformedData(nseNifty50Top20GainerDetailEntityMakerJob.transformSourceData(nseNifty50Top20GainerDetailEntityMakerJob.getDataFromSource()));
    }
}
