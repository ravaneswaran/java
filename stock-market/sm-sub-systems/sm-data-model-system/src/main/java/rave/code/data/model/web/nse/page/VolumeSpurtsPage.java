package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSEVolumeSpurtDetailModel;
import rave.code.data.model.web.nse.WebPage;

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
