package rave.code.entity.quartz;

import rave.code.entity.quartz.id.QuartzCalendarId;

import javax.persistence.*;

@Entity
@Table(name = "QUARTZ_CALENDARS")
@Access(AccessType.FIELD)
public class QuartzCalendarEntity {

    @EmbeddedId
    private QuartzCalendarId quartzCalendarId;
    @Lob
    @Column(name = "CALENDAR")
    private byte[] calendar;

    public QuartzCalendarId getQuartzCalendarId() {
        return quartzCalendarId;
    }

    public void setQuartzCalendarId(QuartzCalendarId quartzCalendarId) {
        this.quartzCalendarId = quartzCalendarId;
    }

    public byte[] getCalendar() {
        return calendar;
    }

    public void setCalendar(byte[] calendar) {
        this.calendar = calendar;
    }
}
