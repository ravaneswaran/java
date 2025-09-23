package rave.code.entity.quartz;

import rave.code.entity.quartz.id.QuartzCalendarId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "QUARTZ_CALENDARS")
public class QuartzCalendarEntity {

    @EmbeddedId
    private QuartzCalendarId quartzCalendarId;
    private Blob calendar;

    public QuartzCalendarId getQuartzCalendarId() {
        return quartzCalendarId;
    }

    public void setQuartzCalendarId(QuartzCalendarId quartzCalendarId) {
        this.quartzCalendarId = quartzCalendarId;
    }

    public Blob getCalendar() {
        return calendar;
    }

    public void setCalendar(Blob calendar) {
        this.calendar = calendar;
    }
}
