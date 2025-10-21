package rave.code.data.model.web.nse.page;

import rave.code.data.model.web.nse.NSEVolumeSpurtDetailModel;

import java.util.List;

public class VolumeSpurtsPage extends NSEWebPage {

    private List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels;

    public VolumeSpurtsPage(){
        this.setVolumeSpurt(true);
    }

}
