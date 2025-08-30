package rave.code.entity.quartz.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuartzTriggerId implements Serializable {

    private String schedulerName;
    private String triggerName;
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
}
