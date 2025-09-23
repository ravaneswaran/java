package rave.code.entity.quartz.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuartzEntryId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;
    @Column(name = "ENTRY_ID")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartzEntryId that = (QuartzEntryId) o;
        return getSchedulerName().equals(that.getSchedulerName()) && getEntryId().equals(that.getEntryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedulerName(), getEntryId());
    }
}
