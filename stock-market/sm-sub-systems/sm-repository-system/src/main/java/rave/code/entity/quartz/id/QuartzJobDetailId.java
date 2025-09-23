package rave.code.entity.quartz.id;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class QuartzJobDetailId implements Serializable {

    @Column(name="SCHED_NAME")
    private String schedulerName;
    @Column(name="JOB_NAME")
    private String jobName;
    @Column(name="JOB_GROUP")
    private String jobGroup;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartzJobDetailId that = (QuartzJobDetailId) o;
        return getSchedulerName().equals(that.getSchedulerName()) && getJobName().equals(that.getJobName()) && getJobGroup().equals(that.getJobGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedulerName(), getJobName(), getJobGroup());
    }
}
