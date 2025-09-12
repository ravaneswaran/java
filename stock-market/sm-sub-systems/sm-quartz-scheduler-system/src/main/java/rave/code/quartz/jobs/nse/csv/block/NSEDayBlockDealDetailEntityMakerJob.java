package rave.code.quartz.jobs.nse.csv.block;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEDayBlockDealDetailEntityMakerJob extends AbstractNSEDayBlockDealDetailEntityMakerJob {

    public NSEDayBlockDealDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/historicalOR/bulk-block-short-deals?csv=true&optionType=block_deals&from=%s&to=%s");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEDayBlockDealDetailEntityMakerJob nseBlockDealEntityMakerJob = new NSEDayBlockDealDetailEntityMakerJob();
        nseBlockDealEntityMakerJob.saveTransformedData(nseBlockDealEntityMakerJob.transformSourceData(nseBlockDealEntityMakerJob.getDataFromSource()));
    }
}
