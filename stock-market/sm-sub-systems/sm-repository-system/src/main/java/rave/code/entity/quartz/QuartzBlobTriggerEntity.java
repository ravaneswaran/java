package rave.code.entity.quartz;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import rave.code.entity.quartz.id.QuartzTriggerId;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "QUARTZ_BLOB_TRIGGERS")
@Access(AccessType.FIELD)
public class QuartzBlobTriggerEntity implements Serializable {

    @EmbeddedId
    private QuartzTriggerId quartzTriggerId;
    @Column(name = "BLOB_DATA")
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
