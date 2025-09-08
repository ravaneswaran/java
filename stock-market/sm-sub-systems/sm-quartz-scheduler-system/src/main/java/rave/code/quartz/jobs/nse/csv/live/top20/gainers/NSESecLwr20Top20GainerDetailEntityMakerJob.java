package rave.code.quartz.jobs.nse.csv.live.top20.gainers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSESecLwr20Top20GainerDetailEntityMakerJob extends AbstractNSETop20GainerDetailEntityMakerJob{

    public NSESecLwr20Top20GainerDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=SecLwr20&csv=true");
        this.setTop20Type("SEVURITY<20");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSESecLwr20Top20GainerDetailEntityMakerJob secLwr20Top20GainerDetailEntityMakerJob = new NSESecLwr20Top20GainerDetailEntityMakerJob();
        secLwr20Top20GainerDetailEntityMakerJob.saveTransformedData(secLwr20Top20GainerDetailEntityMakerJob.transformSourceData(secLwr20Top20GainerDetailEntityMakerJob.getDataFromSource()));
    }
}
