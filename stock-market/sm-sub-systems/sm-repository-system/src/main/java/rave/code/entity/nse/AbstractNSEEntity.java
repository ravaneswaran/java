package rave.code.entity.nse;

import rave.code.entity.AbstractEntity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractNSEEntity extends AbstractEntity {

    @Id
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
