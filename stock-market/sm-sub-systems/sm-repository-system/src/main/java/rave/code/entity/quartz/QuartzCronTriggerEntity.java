package rave.code.entity.quartz;

import rave.code.entity.quartz.id.QuartzTriggerId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "QUARTZ_CRON_TRIGGERS")
public class QuartzCronTriggerEntity {

    @EmbeddedId
    private QuartzTriggerId quartzTriggerId;
    @Column(name="CRON_EXPRESSION")
    private String cronExpression;
    @Column(name="TIME_ZONE_ID")
    private String timeZoneId;

    public QuartzTriggerId getQuartzTriggerId() {
        return quartzTriggerId;
    }

    public void setQuartzTriggerId(QuartzTriggerId quartzTriggerId) {
        this.quartzTriggerId = quartzTriggerId;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
}
