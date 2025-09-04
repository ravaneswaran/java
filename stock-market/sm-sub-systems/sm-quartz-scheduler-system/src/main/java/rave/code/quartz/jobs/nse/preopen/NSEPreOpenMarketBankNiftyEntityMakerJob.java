package rave.code.quartz.jobs.nse.preopen;

import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketBankNiftyEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketBankNiftyEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=BANKNIFTY&csv=true");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketBankNiftyEntityMakerJob nsePreOpenMarketBankNiftyEntityMakerJob = new NSEPreOpenMarketBankNiftyEntityMakerJob();
        nsePreOpenMarketBankNiftyEntityMakerJob.saveTransformedData(nsePreOpenMarketBankNiftyEntityMakerJob.transformSourceData(nsePreOpenMarketBankNiftyEntityMakerJob.getDataFromSource()));
    }
}