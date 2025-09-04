package rave.code.quartz.jobs.nse.csv.preopen;

import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

public class NSEPreOpenMarketOthersEntityMakerJob extends AbstractNSEPreOpenMarketEntityMakerJob {

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketOthersEntityMakerJob() {
        super("https://www.nseindia.com/api/market-data-pre-open?key=OTHERS&csv=true");
        this.preOpenType = "OTHERS";
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketOthersEntityMakerJob nsePreOpenMarketOthersEntityMakerJob = new NSEPreOpenMarketOthersEntityMakerJob();
        nsePreOpenMarketOthersEntityMakerJob.saveTransformedData(nsePreOpenMarketOthersEntityMakerJob.transformSourceData(nsePreOpenMarketOthersEntityMakerJob.getDataFromSource()));
    }
}