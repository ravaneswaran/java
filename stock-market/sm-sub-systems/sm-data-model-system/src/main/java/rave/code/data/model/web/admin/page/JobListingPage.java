package rave.code.data.model.web.admin.page;

import rave.code.data.model.web.admin.JobDetailModel;

import java.util.List;

public class JobListingPage extends AdminWebPage {

    private List<JobDetailModel> jobDetailModels;

    public JobListingPage(){
        this.setJobsListingLink(true);
    }

    public List<JobDetailModel> getJobDetailModels() {
        return jobDetailModels;
    }

    public void setJobDetailModels(List<JobDetailModel> jobDetailModels) {
        this.jobDetailModels = jobDetailModels;
    }
}
