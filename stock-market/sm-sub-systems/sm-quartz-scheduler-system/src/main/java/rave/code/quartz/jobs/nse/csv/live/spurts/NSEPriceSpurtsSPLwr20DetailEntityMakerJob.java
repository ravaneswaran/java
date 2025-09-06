package rave.code.quartz.jobs.nse.csv.live.spurts;

import org.quartz.JobExecutionException;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.logging.Logger;

public class NSEPriceSpurtsSPLwr20DetailEntityMakerJob extends AbstractNSESpurtsDetailEntityMakerJob {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceSpurtsSPLwr20DetailEntityMakerJob.class.getName());

    public NSEPriceSpurtsSPLwr20DetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=SecLwr20&csv=true");
        this.spurtsType = "STOCK-PRICE>20";
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSEPriceSpurtsSPLwr20DetailEntityMakerJob nsePriceSpurtsSPLwr20DetailEntityMakerJob = new NSEPriceSpurtsSPLwr20DetailEntityMakerJob();
        nsePriceSpurtsSPLwr20DetailEntityMakerJob.saveTransformedData(nsePriceSpurtsSPLwr20DetailEntityMakerJob.transformSourceData(nsePriceSpurtsSPLwr20DetailEntityMakerJob.getDataFromSource()));
    }
}
