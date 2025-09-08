package rave.code.quartz.jobs.nse.csv.live.top20.gainers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSESecGtr20Top20GainerDetailEntityMakerJob extends AbstractNSETop20GainerDetailEntityMakerJob{

    public NSESecGtr20Top20GainerDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=SecGtr20&csv=true");
        this.setTop20Type("SEVURITY>20");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSESecGtr20Top20GainerDetailEntityMakerJob nseSecGtr20Top20GainerDetailEntityMakerJob = new NSESecGtr20Top20GainerDetailEntityMakerJob();
        nseSecGtr20Top20GainerDetailEntityMakerJob.saveTransformedData(nseSecGtr20Top20GainerDetailEntityMakerJob.transformSourceData(nseSecGtr20Top20GainerDetailEntityMakerJob.getDataFromSource()));
    }
}
