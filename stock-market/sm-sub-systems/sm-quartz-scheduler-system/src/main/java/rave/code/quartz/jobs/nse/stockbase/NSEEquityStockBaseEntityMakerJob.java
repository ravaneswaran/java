package rave.code.quartz.jobs.nse.stockbase;


import rave.code.utility.log.JavaUtilLogDecor;

import java.util.logging.Logger;

public class NSEEquityStockBaseEntityMakerJob extends AbstractNSEStockBaseCSVEntityMakerJob {

    private static final Logger LOGGER = Logger.getLogger(NSEEquityStockBaseEntityMakerJob.class.getName());

    public NSEEquityStockBaseEntityMakerJob(){
        super("https://nsearchives.nseindia.com/content/equities/EQUITY_L.csv");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEEquityStockBaseEntityMakerJob nseStockBaseEntityMakerJob = new NSEEquityStockBaseEntityMakerJob();
        nseStockBaseEntityMakerJob.saveTransformedData(nseStockBaseEntityMakerJob.transformSourceData(nseStockBaseEntityMakerJob.getDataFromSource()));
    }
}
