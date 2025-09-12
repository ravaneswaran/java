package rave.code.quartz.jobs.nse.csv.bulk;

import rave.code.utility.log.JavaUtilLogDecor;

public class NSEDayBulkDealDetailEntityMakerJob extends AbstractNSEDayBulkDealDetailEntityMakerJob {

    public NSEDayBulkDealDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/historicalOR/bulk-block-short-deals?csv=true&optionType=bulk_deals&from=%s&to=%s");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEDayBulkDealDetailEntityMakerJob nseDayBulkDealEntityMakerJob = new NSEDayBulkDealDetailEntityMakerJob();
        nseDayBulkDealEntityMakerJob.saveTransformedData(nseDayBulkDealEntityMakerJob.transformSourceData(nseDayBulkDealEntityMakerJob.getDataFromSource()));
    }
}
