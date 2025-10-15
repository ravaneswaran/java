package rave.code.nse.web.service;

import rave.code.entity.nse.csv.NSEVolumeSpurtDetailEntity;
import rave.code.nse.web.model.NSEVolumeSpurtDetailModel;
import rave.code.nse.web.model.page.VolumeSpurtsPage;
import rave.code.repository.nse.NSEVolumeSpurtDetailRepository;

import java.util.ArrayList;
import java.util.List;

public class NSEVolumeSpurtsService extends AbstractNSEService<NSEVolumeSpurtDetailEntity, VolumeSpurtsPage> {

    private NSEVolumeSpurtDetailRepository nseVolumeSpurtDetailRepository = new NSEVolumeSpurtDetailRepository();

    public VolumeSpurtsPage getWebPageModel(){
        List<NSEVolumeSpurtDetailEntity> nseVolumeSpurtDetailEntities = this.nseVolumeSpurtDetailRepository.findAll();
        VolumeSpurtsPage volumeSpurtsPage = new VolumeSpurtsPage();
        volumeSpurtsPage.setPriceSpurt(true);
        volumeSpurtsPage.setModelList(this.transformEntities(nseVolumeSpurtDetailEntities));

        return volumeSpurtsPage;
    }

    private List<NSEVolumeSpurtDetailModel> transformEntities(List<NSEVolumeSpurtDetailEntity> nseVolumeSpurtDetailEntities){
        List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels = new ArrayList();
        for (NSEVolumeSpurtDetailEntity nseVolumeSpurtDetailEntity: nseVolumeSpurtDetailEntities) {
            NSEVolumeSpurtDetailModel nseVolumeSpurtDetailModel = new NSEVolumeSpurtDetailModel();

            nseVolumeSpurtDetailModel.setVolume(nseVolumeSpurtDetailEntity.getVolume());
            nseVolumeSpurtDetailModel.setOneWeekAverageVolume(nseVolumeSpurtDetailEntity.getOneWeekAverageVolume());
            nseVolumeSpurtDetailModel.setNoOfTimes(nseVolumeSpurtDetailEntity.getNoOfTimes());
            nseVolumeSpurtDetailModel.setSymbol(nseVolumeSpurtDetailEntity.getSymbol());

            nseVolumeSpurtDetailModels.add(nseVolumeSpurtDetailModel);
        }

        return nseVolumeSpurtDetailModels;
    }

}
