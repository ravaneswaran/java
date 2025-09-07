package rave.code.quartz.jobs.nse.csv.live.spurts;

import org.quartz.JobExecutionException;
import rave.code.utility.log.JavaUtilLogDecor;

import java.util.logging.Logger;

public class NSEPriceSpurtSPGtr20DetailEntityMakerJob extends AbstractNSEPriceSpurtDetailEntityMakerJob {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceSpurtSPGtr20DetailEntityMakerJob.class.getName());

    public NSEPriceSpurtSPGtr20DetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-variations?index=gainers&type=mae&key=SecGtr20&csv=true");
        this.spurtType = "STOCK-PRICE>20";
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSEPriceSpurtSPGtr20DetailEntityMakerJob nsePriceSpurtsDetailEntityMakerJob = new NSEPriceSpurtSPGtr20DetailEntityMakerJob();
        nsePriceSpurtsDetailEntityMakerJob.saveTransformedData(nsePriceSpurtsDetailEntityMakerJob.transformSourceData(nsePriceSpurtsDetailEntityMakerJob.getDataFromSource()));

    }
}
