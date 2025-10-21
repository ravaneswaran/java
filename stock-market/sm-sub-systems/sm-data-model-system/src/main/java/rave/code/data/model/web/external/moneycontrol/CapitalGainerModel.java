package rave.code.data.model.web.external.moneycontrol;

public class CapitalGainerModel extends BSEGenericActiveModel {

    private String group;

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public void setGroup(String group) {
        this.group = group;
    }
}
