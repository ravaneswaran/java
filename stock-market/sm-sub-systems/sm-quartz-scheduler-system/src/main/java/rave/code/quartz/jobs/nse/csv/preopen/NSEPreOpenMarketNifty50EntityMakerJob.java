package rave.code.quartz.jobs.nse.csv.preopen;

import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketNifty50EntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketNifty50EntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=NIFTY&csv=true");
        this.preOpenType = "NIFTY";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketNifty50EntityMakerJob nsePreOpenMarketEntityMakeJob = new NSEPreOpenMarketNifty50EntityMakerJob();
        nsePreOpenMarketEntityMakeJob.saveTransformedData(nsePreOpenMarketEntityMakeJob.transformSourceData(nsePreOpenMarketEntityMakeJob.getDataFromSource()));
    }
}
