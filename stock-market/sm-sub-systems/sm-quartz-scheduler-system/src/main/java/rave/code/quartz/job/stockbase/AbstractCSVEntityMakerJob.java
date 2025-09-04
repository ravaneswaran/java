package rave.code.quartz.job.stockbase;

public abstract class AbstractCSVEntityMakerJob<S, T> extends AbstractEntityMakerJob<S, T> {

    protected String csvDownloadUrl;

    public AbstractCSVEntityMakerJob(String csvDownloadUrl) {
        this.setCsvDownloadUrl(csvDownloadUrl);
    }

    public void setCsvDownloadUrl(String csvDownloadUrl) {
        this.csvDownloadUrl = csvDownloadUrl;
    }
}
