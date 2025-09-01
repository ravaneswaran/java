package rave.code.quartz.job.stockbase;

public abstract class AbstractCSVEntityMakerJob<S, T> extends AbstractEntityMakerJob<S, T> {

    protected String downloadUrl;

    public AbstractCSVEntityMakerJob(String downloadUrl) {
        this.setDownloadUrl(downloadUrl);
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
