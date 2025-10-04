package rave.code.admin.web.service;

import rave.code.admin.web.model.Trigger;
import rave.code.admin.web.page.JobListingPage;
import rave.code.admin.web.page.TriggerListingPage;

import rave.code.entity.quartz.QuartzTriggerEntity;
import rave.code.repository.quartz.QuartzJobDetailRepository;
import rave.code.repository.quartz.QuartzTriggerRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminService {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();
    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();

    public JobListingPage quartzJobDetails() {
        return null;
    }

    public TriggerListingPage listTriggers() {
        TriggerListingPage triggerListingPage = new TriggerListingPage();

        List<QuartzTriggerEntity> quartzTriggerEntities = this.quartzTriggerRepository.findAll();
        List<Trigger> triggers = new ArrayList<>();
        for (QuartzTriggerEntity quartzTriggerEntity : quartzTriggerEntities) {
            Trigger trigger = new Trigger();
            trigger.setSchedulerName(quartzTriggerEntity.getQuartzTriggerId().getSchedulerName());
            trigger.setName(quartzTriggerEntity.getQuartzTriggerId().getTriggerName());
            trigger.setGroup(quartzTriggerEntity.getQuartzTriggerId().getTriggerGroup());
            trigger.setJobName(quartzTriggerEntity.getJobName());
            trigger.setPriority(quartzTriggerEntity.getPriority());
            trigger.setTriggerState(quartzTriggerEntity.getTriggerState());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            trigger.setNextFireTime(simpleDateFormat.format(new Date(quartzTriggerEntity.getNextFireTime())));
            trigger.setPreviousFireTime(simpleDateFormat.format(new Date(quartzTriggerEntity.getPreviousFireTime())));

            triggers.add(trigger);
        }
        triggerListingPage.setTriggers(triggers);

        return triggerListingPage;
    }
}
