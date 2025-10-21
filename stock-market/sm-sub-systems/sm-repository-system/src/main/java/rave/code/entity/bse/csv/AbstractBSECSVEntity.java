package rave.code.entity.bse.csv;

import rave.code.entity.bse.AbstractBSEEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractBSECSVEntity extends AbstractBSEEntity {

    @Id
    @Column(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
