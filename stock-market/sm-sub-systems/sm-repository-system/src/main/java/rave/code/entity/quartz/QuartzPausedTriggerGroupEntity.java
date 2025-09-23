package rave.code.entity.quartz;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import rave.code.entity.quartz.id.QuartzPausedTriggerGroupId;

@Entity
@Table(name = "QUARTZ_PAUSED_TRIGGER_GRPS")
public class QuartzPausedTriggerGroupEntity {

    @EmbeddedId
    private QuartzPausedTriggerGroupId quartzPausedTriggerGroupId;

    public QuartzPausedTriggerGroupId getQuartzPausedTriggerGroupId() {
        return quartzPausedTriggerGroupId;
    }

    public void setQuartzPausedTriggerGroupId(QuartzPausedTriggerGroupId quartzPausedTriggerGroupId) {
        this.quartzPausedTriggerGroupId = quartzPausedTriggerGroupId;
    }
}
