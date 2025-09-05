package rave.code.quartz.jobs.bse.csv.stockbase;

import rave.code.utility.log.JavaUtilLogDecor;

public class BSEStockBaseEntityMakerJob extends AbstractBSEStockBaseCSVEntityMakerJob{

    public BSEStockBaseEntityMakerJob() {
        super("https://www.bseindia.com/download/BhavCopy/Equity/EQ_ISINCODE_310118.zip");
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        BSEStockBaseEntityMakerJob BSEStockBaseEntityMakerJob = new BSEStockBaseEntityMakerJob();
        BSEStockBaseEntityMakerJob.saveTransformedData(BSEStockBaseEntityMakerJob.transformSourceData(BSEStockBaseEntityMakerJob.getDataFromSource()));
    }
}
