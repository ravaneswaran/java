package rave.code.data.model.web.admin.page;

import rave.code.data.model.web.admin.TriggerDetailModel;

import java.util.List;

public class TriggerListingPage extends AdminWebPage {

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
