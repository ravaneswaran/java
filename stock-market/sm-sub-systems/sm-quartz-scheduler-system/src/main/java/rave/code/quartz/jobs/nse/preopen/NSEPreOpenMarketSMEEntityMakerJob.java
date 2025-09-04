package rave.code.quartz.jobs.nse.preopen;

import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketSMEEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketSMEEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=SME&csv=true");
        this.preOpenType = "SME";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketSMEEntityMakerJob nsePreOpenMarketSMEEntityMakerJob = new NSEPreOpenMarketSMEEntityMakerJob();
        nsePreOpenMarketSMEEntityMakerJob.saveTransformedData(nsePreOpenMarketSMEEntityMakerJob.transformSourceData(nsePreOpenMarketSMEEntityMakerJob.getDataFromSource()));
    }
}