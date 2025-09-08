package rave.code.quartz.jobs.nse.csv.live.top20.gainers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSENiftyNext50Top20GainerDetailEntityMakerJob extends AbstractNSETop20GainerDetailEntityMakerJob{

    public NSENiftyNext50Top20GainerDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=NIFTYNEXT50&csv=true");
        this.setTop20Type("NIFTYNEXT50");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSENiftyNext50Top20GainerDetailEntityMakerJob nseNiftyNext50Top20GainerDetailEntityMakerJob = new NSENiftyNext50Top20GainerDetailEntityMakerJob();
        nseNiftyNext50Top20GainerDetailEntityMakerJob.saveTransformedData(nseNiftyNext50Top20GainerDetailEntityMakerJob.transformSourceData(nseNiftyNext50Top20GainerDetailEntityMakerJob.getDataFromSource()));
    }
}
