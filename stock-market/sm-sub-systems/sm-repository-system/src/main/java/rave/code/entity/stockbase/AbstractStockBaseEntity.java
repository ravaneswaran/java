package rave.code.entity.stockbase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class AbstractStockBaseEntity implements Serializable {

    @Id
    protected String id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    protected Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    protected Date modifiedDate;
    @Column(name = "created_by")
    protected String createdBy;
    @Column(name = "modified_by")
    protected String modifiedBy;
    @Transient
    protected boolean newEntity;

    public AbstractStockBaseEntity(){
        this.setId(UUID.randomUUID().toString());
        this.setNewEntity(true);
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public boolean isNewEntity() {
        return newEntity;
    }
    public void setNewEntity(boolean newEntity) {
        this.newEntity = newEntity;
    }

}
