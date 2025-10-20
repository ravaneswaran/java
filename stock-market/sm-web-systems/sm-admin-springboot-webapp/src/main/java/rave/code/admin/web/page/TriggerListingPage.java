package rave.code.admin.web.page;

import rave.code.admin.web.model.TriggerDetailModel;

import java.util.List;

public class TriggerListingPage extends WebPage{

    private List<TriggerDetailModel> triggerDetailModels;

    public TriggerListingPage(){
        this.setTriggersListingLink(true);
    }

    public void setModelList(List<TriggerDetailModel> triggerDetailModels){
        this.triggerDetailModels = triggerDetailModels;
    }

    public List<TriggerDetailModel> getModelList(){
        return this.triggerDetailModels;
    }

}
