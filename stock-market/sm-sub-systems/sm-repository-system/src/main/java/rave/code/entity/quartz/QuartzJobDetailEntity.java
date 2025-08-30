package rave.code.entity.quartz;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rave.code.entity.quartz.id.QuartzJobDetailId;

import java.sql.Blob;

@Entity
@Table(name = "QUARTZ_JOB_DETAILS")
public class QuartzJobDetailEntity {

    @EmbeddedId
    private QuartzJobDetailId quartzJobDetailId;
    private String description;
    private String jobClassName;
    private String isDurable;
    private String isNonConcurrent;
    private String isUpdateData;
    private String requestRecovery;
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
