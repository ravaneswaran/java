package rave.code.entity.quartz;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rave.code.entity.quartz.id.QuartzTriggerId;

import java.sql.Blob;

@Entity
@Table(name = "QUARTZ_BLOB_TRIGGERS")
public class QuartzBlobTriggerEntity {

    @EmbeddedId
    private QuartzTriggerId quartzTriggerId;
    private Blob blobData;

    public QuartzTriggerId getQuartzTriggerId() {
        return quartzTriggerId;
    }

    public void setQuartzTriggerId(QuartzTriggerId quartzTriggerId) {
        this.quartzTriggerId = quartzTriggerId;
    }

    public Blob getBlobData() {
        return blobData;
    }

    public void setBlobData(Blob blobData) {
        this.blobData = blobData;
    }
}
