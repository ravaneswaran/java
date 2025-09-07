package rave.code.quartz.jobs.nse.csv.live.spurts;

import org.quartz.JobExecutionException;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.logging.Logger;

public class NSEPriceSpurtSPLwr20DetailEntityMakerJob extends AbstractNSEPriceSpurtDetailEntityMakerJob {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceSpurtSPLwr20DetailEntityMakerJob.class.getName());

    public NSEPriceSpurtSPLwr20DetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=SecLwr20&csv=true");
        this.spurtType = "STOCK-PRICE<20";
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSEPriceSpurtSPLwr20DetailEntityMakerJob nsePriceSpurtsSPLwr20DetailEntityMakerJob = new NSEPriceSpurtSPLwr20DetailEntityMakerJob();
        nsePriceSpurtsSPLwr20DetailEntityMakerJob.saveTransformedData(nsePriceSpurtsSPLwr20DetailEntityMakerJob.transformSourceData(nsePriceSpurtsSPLwr20DetailEntityMakerJob.getDataFromSource()));
    }
}
