package rave.code.entity.quartz;

import rave.code.entity.quartz.id.QuartzTriggerId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "QUARTZ_TRIGGERS")
public class QuartzTriggerEntity {

    @EmbeddedId
    private QuartzTriggerId quartzTriggerId;
    @Column(name = "JOB_NAME")
    private String jobName;
    @Column(name = "JOB_GROUP")
    private String jobGroup;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NEXT_FIRE_TIME")
    private long nextFireTime;
    @Column(name = "PREV_FIRE_TIME")
    private long previousFireTime;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "TRIGGER_STATE")
    private String triggerState;
    @Column(name = "TRIGGER_TYPE")
    private String triggerType;
    @Column(name = "START_TIME")
    private long startTime;
    @Column(name = "END_TIME")
    private long endTime;
    @Column(name = "CALENDAR_NAME")
    private String calendarName;
    @Column(name = "MISFIRE_INSTR")
    private int missFireInstruction;
    @Column(name = "JOB_DATA")
    private byte[] jobData;

    public QuartzTriggerId getQuartzTriggerId() {
        return quartzTriggerId;
    }

    public void setQuartzTriggerId(QuartzTriggerId quartzTriggerId) {
        this.quartzTriggerId = quartzTriggerId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(long nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public long getPreviousFireTime() {
        return previousFireTime;
    }

    public void setPreviousFireTime(long previousFireTime) {
        this.previousFireTime = previousFireTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public int getMissFireInstruction() {
        return missFireInstruction;
    }

    public void setMissFireInstruction(int missFireInstruction) {
        this.missFireInstruction = missFireInstruction;
    }

    public byte[] getJobData() {
        return jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }
}
