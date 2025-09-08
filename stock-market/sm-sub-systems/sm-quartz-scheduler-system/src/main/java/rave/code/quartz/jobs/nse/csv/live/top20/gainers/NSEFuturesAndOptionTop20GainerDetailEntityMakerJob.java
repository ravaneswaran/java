package rave.code.quartz.jobs.nse.csv.live.top20.gainers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEFuturesAndOptionTop20GainerDetailEntityMakerJob extends AbstractNSETop20GainerDetailEntityMakerJob{

    public NSEFuturesAndOptionTop20GainerDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=FOSec&csv=true");
        this.setTop20Type("FOSecurity");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEFuturesAndOptionTop20GainerDetailEntityMakerJob nseFuturesAndOptionTop20GainerDetailEntityMakerJob = new NSEFuturesAndOptionTop20GainerDetailEntityMakerJob();
        nseFuturesAndOptionTop20GainerDetailEntityMakerJob.saveTransformedData(nseFuturesAndOptionTop20GainerDetailEntityMakerJob.transformSourceData(nseFuturesAndOptionTop20GainerDetailEntityMakerJob.getDataFromSource()));
    }
}