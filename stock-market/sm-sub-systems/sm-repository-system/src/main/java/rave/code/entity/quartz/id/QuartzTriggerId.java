package rave.code.entity.quartz.id;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class QuartzTriggerId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;
    @Column(name = "TRIGGER_NAME")
    private String triggerName;
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
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
        QuartzTriggerId that = (QuartzTriggerId) o;
        return getSchedulerName().equals(that.getSchedulerName()) && getTriggerName().equals(that.getTriggerName()) && getTriggerGroup().equals(that.getTriggerGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedulerName(), getTriggerName(), getTriggerGroup());
    }
}
