package rave.code.entity.quartz;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import rave.code.entity.quartz.id.QuartzTriggerId;

@Entity
@Table(name = "QUARTZ_SIMPLE_TRIGGERS")
public class QuartzSimpleTriggerEntity {

    @EmbeddedId
    private QuartzTriggerId quartzTriggerId;
    @Column(name = "REPEAT_COUNT")
    private long repeatCount;
    @Column(name = "REPEAT_INTERVAL")
    private long repeatInterval;
    @Column(name = "TIMES_TRIGGERED")
    private long timesTriggered;

    public QuartzTriggerId getQuartzTriggerId() {
        return quartzTriggerId;
    }

    public void setQuartzTriggerId(QuartzTriggerId quartzTriggerId) {
        this.quartzTriggerId = quartzTriggerId;
    }

    public long getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(long repeatCount) {
        this.repeatCount = repeatCount;
    }

    public long getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public long getTimesTriggered() {
        return timesTriggered;
    }

    public void setTimesTriggered(long timesTriggered) {
        this.timesTriggered = timesTriggered;
    }
}
