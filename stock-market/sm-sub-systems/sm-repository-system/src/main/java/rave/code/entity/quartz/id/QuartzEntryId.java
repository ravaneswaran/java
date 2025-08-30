package rave.code.entity.quartz.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuartzEntryId implements Serializable {

    private String schedulerName;
    private String entryId;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }
}
