package rave.code.quartz.jobs.nse.csv.preopen;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketBankNiftyEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    public NSEPreOpenMarketBankNiftyEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=BANKNIFTY&csv=true");
        this.preOpenType = "BANKNIFTY";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketBankNiftyEntityMakerJob nsePreOpenMarketBankNiftyEntityMakerJob = new NSEPreOpenMarketBankNiftyEntityMakerJob();
        nsePreOpenMarketBankNiftyEntityMakerJob.saveTransformedData(nsePreOpenMarketBankNiftyEntityMakerJob.transformSourceData(nsePreOpenMarketBankNiftyEntityMakerJob.getDataFromSource()));
    }
}