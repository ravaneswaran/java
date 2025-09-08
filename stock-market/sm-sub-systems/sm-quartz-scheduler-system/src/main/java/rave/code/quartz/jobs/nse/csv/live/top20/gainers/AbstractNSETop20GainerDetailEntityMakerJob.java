package rave.code.quartz.jobs.nse.csv.live.top20.gainers;

import rave.code.quartz.jobs.nse.csv.live.top20.AbstractNSETop20DetailEntityMakerJob;

public class AbstractNSETop20GainerDetailEntityMakerJob extends AbstractNSETop20DetailEntityMakerJob {

    public AbstractNSETop20GainerDetailEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
    }
}
