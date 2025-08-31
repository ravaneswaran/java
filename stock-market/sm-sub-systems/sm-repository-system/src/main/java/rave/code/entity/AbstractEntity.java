package rave.code.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity implements Serializable {

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

    public AbstractEntity(){
        this.setId(UUID.randomUUID().toString());
        Date now = new Date();
        this.setCreatedDate(now);
        this.setModifiedDate(now);
        this.setCreatedBy("SYSTEM");
        this.setModifiedBy("SYSTEM");
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

    public Date getCreatedDate() {return createdDate;}
    public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}

    public Date getModifiedDate() {return modifiedDate;}
    public void setModifiedDate(Date modifiedDate) {this.modifiedDate = modifiedDate;}

    public String getCreatedBy() {return createdBy;}
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}

    public String getModifiedBy() {return modifiedBy;}
    public void setModifiedBy(String modifiedBy) {this.modifiedBy = modifiedBy;}
}
