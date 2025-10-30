package rave.code.entity.nse;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_day_price_last_run_detail")
@Access(AccessType.FIELD)
public class NSEDayPriceLastRunDetailEntity extends AbstractNSEEntity {

    @Column(name = "last_run_at")
    private Date lastRunAt;

    @Column(name = "last_run_at_str")
    private String lastRunAtStr;

    public Date getLastRunAt() {
        return lastRunAt;
    }

    public void setLastRunAt(Date lastRunAt) {
        this.lastRunAt = lastRunAt;
    }

    public String getLastRunAtStr() {
        return lastRunAtStr;
    }

    public void setLastRunAtStr(String lastRunAtStr) {
        this.lastRunAtStr = lastRunAtStr;
    }
}
