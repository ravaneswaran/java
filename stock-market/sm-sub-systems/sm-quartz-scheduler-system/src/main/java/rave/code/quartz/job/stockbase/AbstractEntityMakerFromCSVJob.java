package rave.code.quartz.job.stockbase;

public abstract class AbstractEntityMakerFromCSVJob<S, T> extends AbstractEntityMakerJob<S, T> {

    protected String downloadUrl;

    public AbstractEntityMakerFromCSVJob(String downloadUrl) {
        this.setDownloadUrl(downloadUrl);
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
