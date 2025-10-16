package rave.code.admin.web.page;

import rave.code.admin.web.model.TriggerModel;

import java.util.List;

public class TriggerListingPage extends WebPage{

    private List<TriggerModel> triggers;

    public TriggerListingPage(){
        this.setTriggersLink(true);
    }

    public void setTriggers(List<TriggerModel> triggers) {
        this.triggers = triggers;
    }

    public List<TriggerModel> getTriggers() {
        return this.triggers;
    }
}
