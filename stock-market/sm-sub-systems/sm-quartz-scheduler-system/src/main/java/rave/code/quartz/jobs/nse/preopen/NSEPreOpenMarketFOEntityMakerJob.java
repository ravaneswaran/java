package rave.code.quartz.jobs.nse.preopen;

import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketFOEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketFOEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=FO&csv=true");
        this.preOpenType = "FO";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketFOEntityMakerJob nsePreOpenMarketFOEntityMakerJob = new NSEPreOpenMarketFOEntityMakerJob();
        nsePreOpenMarketFOEntityMakerJob.saveTransformedData(nsePreOpenMarketFOEntityMakerJob.transformSourceData(nsePreOpenMarketFOEntityMakerJob.getDataFromSource()));
    }
}