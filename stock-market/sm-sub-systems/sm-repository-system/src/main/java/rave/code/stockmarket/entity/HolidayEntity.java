package rave.code.stockmarket.entity;

import rave.code.entity.AbstractTestEntity;

import javax.persistence.*;

@Entity
@Table(name = "holidays")
@Access(AccessType.PROPERTY)
public class HolidayEntity extends AbstractTestEntity {

    private String id;
    private String holidate;
    private String holiday;
    private String description;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "holidate")
    public String getHolidate() {
        return holidate;
    }
    public void setHolidate(String holidate) {
        this.holidate = holidate;
    }

    @Column(name = "holiday")
    public String getHoliday() {
        return holiday;
    }
    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
