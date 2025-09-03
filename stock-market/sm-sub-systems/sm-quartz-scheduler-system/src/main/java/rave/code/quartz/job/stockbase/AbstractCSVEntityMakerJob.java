package rave.code.quartz.job.stockbase;

public abstract class AbstractCSVEntityMakerJob<S, T> extends AbstractEntityMakerJob<S, T> {

    protected String url;

    public AbstractCSVEntityMakerJob(String url) {
        this.setUrl(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
