package rave.code.entity.quartz.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuartzPausedTriggerGroupId implements Serializable {

    private String schedulerName;
    private String triggerGroup;
}
