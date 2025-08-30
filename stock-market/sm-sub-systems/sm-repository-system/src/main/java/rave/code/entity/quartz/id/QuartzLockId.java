package rave.code.entity.quartz.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuartzLockId implements Serializable {

    private String schedulerName;
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
}
