package rave.code.entity.quartz.id;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class QuartzCalendarId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;
    @Column(name = "CALENDAR_NAME")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartzCalendarId that = (QuartzCalendarId) o;
        return getSchedulerName().equals(that.getSchedulerName()) && getCalendarName().equals(that.getCalendarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedulerName(), getCalendarName());
    }
}
