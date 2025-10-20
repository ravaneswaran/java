package rave.code.admin.web.page;

import rave.code.admin.web.model.JobDetailModel;

import java.util.List;

public class JobListingPage extends WebPage{

    private List<JobDetailModel> jobDetailModels;

    public JobListingPage(){
        this.setJobsListingLink(true);
    }

    public void setModelList(List<JobDetailModel> jobDetailModels){
        this.jobDetailModels = jobDetailModels;
    }

    public List<JobDetailModel> getModelList(){
        return this.jobDetailModels;
    }
}
