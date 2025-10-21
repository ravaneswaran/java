package rave.code.entity.quartz;

import rave.code.entity.quartz.id.QuartzInstanceId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "QUARTZ_SCHEDULER_STATE")
public class QuartzSchedulerStateEntity {

    @EmbeddedId
    private QuartzInstanceId quartzInstanceId;
    @Column(name = "LAST_CHECKIN_TIME")
    private long lastCheckInTime;
    @Column(name = "CHECKIN_INTERVAL")
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
