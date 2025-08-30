package rave.code.entity.quartz;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rave.code.entity.quartz.id.QuartzCalendarId;

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
