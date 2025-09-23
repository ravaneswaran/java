package rave.code.entity.quartz.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuartzPausedTriggerGroupId implements Serializable {

    private String schedulerName;
    private String triggerGroup;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartzPausedTriggerGroupId that = (QuartzPausedTriggerGroupId) o;
        return schedulerName.equals(that.schedulerName) && triggerGroup.equals(that.triggerGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedulerName, triggerGroup);
    }
}
