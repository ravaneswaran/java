package rave.code.admin.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.admin.TriggerDetailModel;
import rave.code.data.model.web.admin.page.TriggerListingWebPage;
import rave.code.entity.quartz.QuartzTriggerEntity;
import rave.code.repository.quartz.QuartzTriggerRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TriggerListingService extends AbstractAdminService<QuartzTriggerEntity, TriggerDetailModel, TriggerListingWebPage>{

    private QuartzTriggerRepository quartzTriggerRepository = new QuartzTriggerRepository();

    @Override
    public TriggerListingWebPage getWebPage() {
        TriggerListingWebPage triggerListingPage = new TriggerListingWebPage();
        triggerListingPage.setTriggerDetailModels(this.transformEntities(this.getEntities()));
        return triggerListingPage;
    }

    @Override
    public List<QuartzTriggerEntity> getEntities() {
        return this.quartzTriggerRepository.findAll();
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
