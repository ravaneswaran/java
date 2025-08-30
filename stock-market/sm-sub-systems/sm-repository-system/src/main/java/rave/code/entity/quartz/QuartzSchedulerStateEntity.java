package rave.code.entity.quartz;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rave.code.entity.quartz.id.QuartzInstanceId;

@Entity
@Table(name = "QUARTZ_SCHEDULER_STATE")
public class QuartzSchedulerStateEntity {

    @EmbeddedId
    private QuartzInstanceId quartzInstanceId;
    private long lastCheckInTime;
    private long checkInInterval;

    public QuartzInstanceId getQuartzInstanceId() {
        return quartzInstanceId;
    }

    public void setQuartzInstanceId(QuartzInstanceId quartzInstanceId) {
        this.quartzInstanceId = quartzInstanceId;
    }

    public long getLastCheckInTime() {
        return lastCheckInTime;
    }

    public void setLastCheckInTime(long lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    public long getCheckInInterval() {
        return checkInInterval;
    }

    public void setCheckInInterval(long checkInInterval) {
        this.checkInInterval = checkInInterval;
    }
}
