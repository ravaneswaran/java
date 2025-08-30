package rave.code.entity.quartz.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuartzCalendarId implements Serializable {

    private String schedulerName;
    private String calendarName;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }
}
