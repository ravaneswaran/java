package rave.code.admin.web.service;

import rave.code.admin.web.model.TriggerModel;
import rave.code.admin.web.page.TriggerListingPage;
import rave.code.entity.quartz.QuartzTriggerEntity;
import rave.code.repository.quartz.QuartzJobDetailRepository;
import rave.code.repository.quartz.QuartzTriggerRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AdminService {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();
    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();

    public TriggerListingPage listTriggers() {
        TriggerListingPage triggerListingPage = new TriggerListingPage();
        List<QuartzTriggerEntity> quartzTriggerEntities = this.quartzTriggerRepository.findAll();
        List<TriggerModel> triggers = new ArrayList<>();
        for (QuartzTriggerEntity quartzTriggerEntity : quartzTriggerEntities) {
            TriggerModel trigger = new TriggerModel();
            trigger.setId(UUID.randomUUID().toString());
            trigger.setSchedulerName(quartzTriggerEntity.getQuartzTriggerId().getSchedulerName());
            trigger.setName(quartzTriggerEntity.getQuartzTriggerId().getTriggerName());
            trigger.setGroup(quartzTriggerEntity.getQuartzTriggerId().getTriggerGroup());
            trigger.setJobName(quartzTriggerEntity.getJobName());
            trigger.setPriority(quartzTriggerEntity.getPriority());
            trigger.setTriggerState(quartzTriggerEntity.getTriggerState());

            trigger.setName("Test Name");
            trigger.setGroup("Test Group");
            trigger.setJobName("Test Job Name");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            trigger.setNextFireTime(simpleDateFormat.format(new Date(quartzTriggerEntity.getNextFireTime())));
            trigger.setPreviousFireTime(simpleDateFormat.format(new Date(quartzTriggerEntity.getPreviousFireTime())));
            triggers.add(trigger);
        }
        triggerListingPage.setTriggers(triggers);

        return triggerListingPage;
    }
}
