package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.VolumeShockerDetailModel;

import java.util.List;

public class VolumeShockerWebPage extends BSEWebPage {

    private List<VolumeShockerDetailModel> volumeShockerDetailModels;

    public VolumeShockerWebPage(){
        this.setVolumeShockersLink(true);
    }

    public List<VolumeShockerDetailModel> getVolumeShockerDetailModels() {
        return volumeShockerDetailModels;
    }

    public void setVolumeShockerDetailModels(List<VolumeShockerDetailModel> volumeShockerDetailModels) {
        this.volumeShockerDetailModels = volumeShockerDetailModels;
    }
}
