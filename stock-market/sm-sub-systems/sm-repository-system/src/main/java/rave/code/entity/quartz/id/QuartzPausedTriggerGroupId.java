package rave.code.entity.quartz.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuartzPausedTriggerGroupId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartzPausedTriggerGroupId that = (QuartzPausedTriggerGroupId) o;
        return getSchedulerName().equals(that.getSchedulerName()) && getTriggerGroup().equals(that.getTriggerGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedulerName(), getTriggerGroup());
    }
}
