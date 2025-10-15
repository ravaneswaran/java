package rave.code.nse.web.model.page;

import rave.code.nse.web.model.NSEVolumeSpurtDetailModel;
import rave.code.nse.web.model.WebPage;

import java.util.List;

public class VolumeSpurtsPage extends WebPage {

    private List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels;

    public VolumeSpurtsPage(){
        this.setVolumeSpurt(true);
    }

    public void setModelList(List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels) {
        this.nseVolumeSpurtDetailModels = nseVolumeSpurtDetailModels;
    }

    public List<NSEVolumeSpurtDetailModel> getNseVolumeSpurtDetailModels() {
        return nseVolumeSpurtDetailModels;
    }
}
