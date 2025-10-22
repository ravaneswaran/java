package rave.code.entity.nse;

import rave.code.entity.AbstractEntity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

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

    public AbstractNSEEntity(){
        this.setId(UUID.randomUUID().toString());
    }
}
