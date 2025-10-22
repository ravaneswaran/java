package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSEVolumeSpurtDetailModel;

import java.util.List;

public class VolumeSpurtsWebPage extends NSEWebPage {

    private List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels;

    public VolumeSpurtsWebPage(){
        this.setVolumeSpurt(true);
    }

    public List<NSEVolumeSpurtDetailModel> getNseVolumeSpurtDetailModels() {
        return nseVolumeSpurtDetailModels;
    }

    public void setNseVolumeSpurtDetailModels(List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels) {
        this.nseVolumeSpurtDetailModels = nseVolumeSpurtDetailModels;
    }
}
