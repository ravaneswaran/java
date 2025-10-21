package rave.code.admin.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.admin.JobDetailModel;
import rave.code.data.model.web.admin.page.JobListingPage;
import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.repository.quartz.QuartzJobDetailRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JobListingService extends AbstractAdminService<QuartzJobDetailEntity, JobDetailModel> {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();

    public JobListingPage listNSEJobs() {
        JobListingPage jobListingPage = new JobListingPage();
        List<QuartzJobDetailEntity> quartzJobDetailEntities = quartzJobDetailRepository.findAll();
        jobListingPage.setModelList(this.transformEntities(quartzJobDetailEntities));
        return jobListingPage;
    }

    @Override
    public List<JobDetailModel> transformEntities(List<QuartzJobDetailEntity> entities) {
        List<JobDetailModel> jobDetailModels = new ArrayList<>();
        for (QuartzJobDetailEntity quartzJobDetailEntity : entities) {
            JobDetailModel jobDetailModel = new JobDetailModel();
            jobDetailModel.setId(UUID.randomUUID().toString());
            jobDetailModel.setName(quartzJobDetailEntity.getQuartzJobDetailId().getJobName());
            jobDetailModel.setGroup(quartzJobDetailEntity.getQuartzJobDetailId().getJobGroup());
            jobDetailModel.setSchedulerName(quartzJobDetailEntity.getQuartzJobDetailId().getSchedulerName());
            jobDetailModel.setDescription(quartzJobDetailEntity.getDescription());
            jobDetailModel.setIsDurable(quartzJobDetailEntity.getIsDurable());
            jobDetailModel.setClassName(quartzJobDetailEntity.getJobClassName());
            jobDetailModel.setIsNonConcurrent(quartzJobDetailEntity.getIsNonConcurrent());
            jobDetailModel.setRequestRecovery(quartzJobDetailEntity.getRequestRecovery());
            jobDetailModels.add(jobDetailModel);
        }
        return jobDetailModels;
    }
}
