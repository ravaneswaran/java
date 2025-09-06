package rave.code.quartz.jobs.nse.csv.live.spurts;

import org.quartz.JobExecutionException;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.logging.Logger;

public class NSEPriceSpurtsSPGtr20DetailEntityMakerJob extends AbstractNSEPriceSpurtsDetailEntityMakerJob {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceSpurtsSPGtr20DetailEntityMakerJob.class.getName());

    public NSEPriceSpurtsSPGtr20DetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=SecGtr20&csv=true");
        this.spurtsType = "STOCK-PRICE>20";
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSEPriceSpurtsSPGtr20DetailEntityMakerJob nsePriceSpurtsDetailEntityMakerJob = new NSEPriceSpurtsSPGtr20DetailEntityMakerJob();
        nsePriceSpurtsDetailEntityMakerJob.saveTransformedData(nsePriceSpurtsDetailEntityMakerJob.transformSourceData(nsePriceSpurtsDetailEntityMakerJob.getDataFromSource()));

    }
}
