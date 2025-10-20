package rave.code.admin.web.service;

import rave.code.admin.web.model.TriggerDetailModel;
import rave.code.admin.web.page.TriggerListingPage;
import rave.code.entity.quartz.QuartzTriggerEntity;
import rave.code.repository.quartz.QuartzTriggerRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TriggerListingService extends AbstractAdminService<QuartzTriggerEntity, TriggerDetailModel>{

    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();

    public TriggerListingPage listNSETriggers() {
        TriggerListingPage triggerListingPage = new TriggerListingPage();
        List<QuartzTriggerEntity> quartzTriggerEntities = this.quartzTriggerRepository.findAll();
        triggerListingPage.setModelList(this.transformEntities(quartzTriggerEntities));
        return triggerListingPage;
    }

    @Override
    public List<TriggerDetailModel> transformEntities(List<QuartzTriggerEntity> entities) {
        List<TriggerDetailModel> triggerDetailModels = new ArrayList<>();
        for (QuartzTriggerEntity quartzTriggerEntity : entities) {
            TriggerDetailModel triggerDetailModel = new TriggerDetailModel();
            triggerDetailModel.setId(UUID.randomUUID().toString());
            triggerDetailModel.setSchedulerName(quartzTriggerEntity.getQuartzTriggerId().getSchedulerName());
            triggerDetailModel.setName(quartzTriggerEntity.getQuartzTriggerId().getTriggerName());
            triggerDetailModel.setGroup(quartzTriggerEntity.getQuartzTriggerId().getTriggerGroup());
            triggerDetailModel.setJobName(quartzTriggerEntity.getJobName());
            triggerDetailModel.setPriority(quartzTriggerEntity.getPriority());
            triggerDetailModel.setTriggerState(quartzTriggerEntity.getTriggerState());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            triggerDetailModel.setNextFireTime(simpleDateFormat.format(new Date(quartzTriggerEntity.getNextFireTime())));
            triggerDetailModel.setPreviousFireTime(simpleDateFormat.format(new Date(quartzTriggerEntity.getPreviousFireTime())));

            triggerDetailModels.add(triggerDetailModel);
        }
        return triggerDetailModels;
    }
}
