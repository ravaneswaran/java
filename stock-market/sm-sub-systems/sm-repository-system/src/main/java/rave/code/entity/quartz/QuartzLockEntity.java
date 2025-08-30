package rave.code.entity.quartz;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rave.code.entity.quartz.id.QuartzLockId;

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
