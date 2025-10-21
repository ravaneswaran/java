package rave.code.data.model.web.bse.page;

import rave.code.data.model.web.bse.VolumeShockerDetailModel;

import java.util.List;

public class VolumeShockerWebPage extends BSEWebPage {

    private List<VolumeShockerDetailModel> volumeShockerStocks;

    public List<VolumeShockerDetailModel> getVolumeShockerStocks() {
        return volumeShockerStocks;
    }

    public void setVolumeShockerStocks(List<VolumeShockerDetailModel> volumeShockerStocks) {
        this.volumeShockerStocks = volumeShockerStocks;
    }
}
