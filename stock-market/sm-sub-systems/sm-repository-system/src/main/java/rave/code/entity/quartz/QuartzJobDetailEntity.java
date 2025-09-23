package rave.code.entity.quartz;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import rave.code.entity.quartz.id.QuartzJobDetailId;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import java.sql.Blob;

@Entity
@Table(name = "QUARTZ_JOB_DETAILS")
@Access(AccessType.FIELD)
public class QuartzJobDetailEntity {

    @EmbeddedId
    private QuartzJobDetailId quartzJobDetailId;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="JOB_CLASS_NAME")
    private String jobClassName;
    @Column(name="IS_DURABLE")
    private String isDurable;
    @Column(name="IS_NONCONCURRENT")
    private String isNonConcurrent;
    @Column(name="IS_UPDATE_DATA")
    private String isUpdateData;
    @Column(name="REQUESTS_RECOVERY")
    private String requestRecovery;
    @Column(name="JOB_DATA")
    private Blob jobData;

    public QuartzJobDetailId getQuartzJobDetailId() {
        return quartzJobDetailId;
    }

    public void setQuartzJobDetailId(QuartzJobDetailId quartzJobDetailId) {
        this.quartzJobDetailId = quartzJobDetailId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getIsNonConcurrent() {
        return isNonConcurrent;
    }

    public void setIsNonConcurrent(String isNonConcurrent) {
        this.isNonConcurrent = isNonConcurrent;
    }

    public String getIsUpdateData() {
        return isUpdateData;
    }

    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData;
    }

    public String getRequestRecovery() {
        return requestRecovery;
    }

    public void setRequestRecovery(String requestRecovery) {
        this.requestRecovery = requestRecovery;
    }

    public Blob getJobData() {
        return jobData;
    }

    public void setJobData(Blob jobData) {
        this.jobData = jobData;
    }
}
