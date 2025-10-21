package rave.code.entity.quartz.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuartzInstanceId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;
    @Column(name = "INSTANCE_NAME")
    private String instanceName;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartzInstanceId that = (QuartzInstanceId) o;
        return getSchedulerName().equals(that.getSchedulerName()) && getInstanceName().equals(that.getInstanceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedulerName(), getInstanceName());
    }
}
