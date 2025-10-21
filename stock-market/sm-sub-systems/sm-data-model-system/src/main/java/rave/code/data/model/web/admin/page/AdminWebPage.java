package rave.code.data.model.web.admin.page;

import rave.code.data.model.web.AbstractWebPage;

public class AdminWebPage extends AbstractWebPage {

    private boolean triggersListingLink;
    private boolean jobsListingLink;

    public boolean isTriggersListingLink() {
        return triggersListingLink;
    }

    public void setTriggersListingLink(boolean triggersListingLink) {
        this.triggersListingLink = triggersListingLink;
    }

    public boolean isJobsListingLink() {
        return jobsListingLink;
    }

    public void setJobsListingLink(boolean jobsListingLink) {
        this.jobsListingLink = jobsListingLink;
    }

}
