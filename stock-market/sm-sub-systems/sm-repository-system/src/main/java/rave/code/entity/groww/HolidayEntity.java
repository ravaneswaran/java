package rave.code.entity.groww;

import javax.persistence.*;

@Entity
@Table(name = "holidays")
@Access(AccessType.FIELD)
public class HolidayEntity extends AbstractGrowwEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "holidate")
    private String holidate;
    @Column(name = "holiday")
    private String holiday;
    @Column(name = "description")
    private String description;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getHolidate() {
        return holidate;
    }
    public void setHolidate(String holidate) {
        this.holidate = holidate;
    }

    public String getHoliday() {
        return holiday;
    }
    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
