package rave.code.entity.quartz;

import javax.persistence.*;

import rave.code.entity.quartz.id.QuartzEntryId;

@Entity
@Table(name = "QUARTZ_FIRED_TRIGGERS")
@Access(AccessType.FIELD)
public class QuartzFiredTriggerEntity {

    @EmbeddedId
    private QuartzEntryId quartzEntryId;
    @Column(name = "TRIGGER_NAME")
    private String triggerName;
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;
    @Column(name = "INSTANCE_NAME")
    private String instanceName;
    @Column(name = "FIRED_TIME")
    private long firedTime;
    @Column(name = "SCHED_TIME")
    private long scheduledTime;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "STATE")
    private String state;
    @Column(name = "JOB_NAME")
    private String jobName;
    @Column(name = "JOB_GROUP")
    private String jobGroup;
    @Column(name = "IS_NONCONCURRENT")
    private String isNonConcurrent;
    @Column(name = "REQUESTS_RECOVERY")
    private String requestRecovery;

    public QuartzEntryId getQuartzEntryId() {
        return quartzEntryId;
    }

    public void setQuartzEntryId(QuartzEntryId quartzEntryId) {
        this.quartzEntryId = quartzEntryId;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public long getFiredTime() {
        return firedTime;
    }

    public void setFiredTime(long firedTime) {
        this.firedTime = firedTime;
    }

    public long getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(long scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getIsNonConcurrent() {
        return isNonConcurrent;
    }

    public void setIsNonConcurrent(String isNonConcurrent) {
        this.isNonConcurrent = isNonConcurrent;
    }

    public String getRequestRecovery() {
        return requestRecovery;
    }

    public void setRequestRecovery(String requestRecovery) {
        this.requestRecovery = requestRecovery;
    }
}
