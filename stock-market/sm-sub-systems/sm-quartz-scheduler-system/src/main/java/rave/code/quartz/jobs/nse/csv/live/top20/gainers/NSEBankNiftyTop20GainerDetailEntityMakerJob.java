package rave.code.quartz.jobs.nse.csv.live.top20.gainers;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEBankNiftyTop20GainerDetailEntityMakerJob extends AbstractNSETop20GainerDetailEntityMakerJob{

    public NSEBankNiftyTop20GainerDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=BANKNIFTY&csv=true");
        this.setTop20Type("BANKNIFTY");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEBankNiftyTop20GainerDetailEntityMakerJob nseBankNiftyTop20GainerDetailEntityMakerJob = new NSEBankNiftyTop20GainerDetailEntityMakerJob();
        nseBankNiftyTop20GainerDetailEntityMakerJob.saveTransformedData(nseBankNiftyTop20GainerDetailEntityMakerJob.transformSourceData(nseBankNiftyTop20GainerDetailEntityMakerJob.getDataFromSource()));
    }
}
