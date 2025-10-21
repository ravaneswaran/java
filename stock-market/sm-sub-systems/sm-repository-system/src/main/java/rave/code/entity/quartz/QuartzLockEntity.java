package rave.code.entity.quartz;

import rave.code.entity.quartz.id.QuartzLockId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "QUARTZ_LOCKS")
public class QuartzLockEntity {

    @EmbeddedId
    private QuartzLockId quartzLockId;

    public QuartzLockId getQuartzLockId() {
        return quartzLockId;
    }

    public void setQuartzLockId(QuartzLockId quartzLockId) {
        this.quartzLockId = quartzLockId;
    }
}
