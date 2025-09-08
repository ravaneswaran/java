package rave.code.quartz.jobs.nse.csv.live.top20.losers;

import rave.code.quartz.jobs.nse.csv.live.top20.AbstractNSETop20DetailEntityMakerJob;

public class AbstractNSETop20LoserDetailEntityMakerJob extends AbstractNSETop20DetailEntityMakerJob {

    public AbstractNSETop20LoserDetailEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
        super.setTop20Type("Loser");
        super.setTop20SubType(this.top20SubType);
    }

}