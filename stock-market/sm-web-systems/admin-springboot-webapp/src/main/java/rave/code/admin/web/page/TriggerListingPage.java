package rave.code.admin.web.page;

import rave.code.admin.web.model.Trigger;

import java.util.List;

public class TriggerListingPage extends WebPage{

    private List<Trigger> triggers;

    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    public List<Trigger> getTriggers() {
        return this.triggers;
    }
}
