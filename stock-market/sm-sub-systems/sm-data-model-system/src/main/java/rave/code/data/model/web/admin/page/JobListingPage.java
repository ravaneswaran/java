package rave.code.data.model.web.admin.page;

import rave.code.data.model.web.admin.JobDetailModel;

import java.util.List;

public class JobListingPage extends AdminWebPage {

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
