package rave.code.data.model.web.admin.page;

import rave.code.data.model.web.admin.TriggerDetailModel;

import java.util.List;

public class TriggerListingWebPage extends AdminWebPage {

    private List<TriggerDetailModel> triggerDetailModels;

    public TriggerListingWebPage(){
        this.setTriggersListingLink(true);
    }

    public List<TriggerDetailModel> getTriggerDetailModels() {
        return triggerDetailModels;
    }

    public void setTriggerDetailModels(List<TriggerDetailModel> triggerDetailModels) {
        this.triggerDetailModels = triggerDetailModels;
    }
}
