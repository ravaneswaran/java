package rave.code.entity.quartz.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuartzLockId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;
    @Column(name = "LOCK_NAME")
    private String lockName;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartzLockId that = (QuartzLockId) o;
        return getSchedulerName().equals(that.getSchedulerName()) && getLockName().equals(that.getLockName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedulerName(), getLockName());
    }
}
