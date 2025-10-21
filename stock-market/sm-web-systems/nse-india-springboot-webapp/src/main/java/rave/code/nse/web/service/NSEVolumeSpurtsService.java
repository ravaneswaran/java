package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.entity.nse.csv.NSEVolumeSpurtDetailEntity;
import rave.code.data.model.web.nse.NSEVolumeSpurtDetailModel;
import rave.code.data.model.web.nse.page.VolumeSpurtsPage;
import rave.code.repository.nse.NSEVolumeSpurtDetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSEVolumeSpurtsService extends AbstractNSEService<NSEVolumeSpurtDetailEntity, VolumeSpurtsPage> {

    private NSEVolumeSpurtDetailRepository nseVolumeSpurtDetailRepository = new NSEVolumeSpurtDetailRepository();

    public VolumeSpurtsPage getWebPageModel(){
        List<NSEVolumeSpurtDetailEntity> nseVolumeSpurtDetailEntities = this.nseVolumeSpurtDetailRepository.findAll();
        VolumeSpurtsPage volumeSpurtsPage = new VolumeSpurtsPage();
        volumeSpurtsPage.setModelList(this.transformEntities(nseVolumeSpurtDetailEntities));

        return volumeSpurtsPage;
    }

    private List<NSEVolumeSpurtDetailModel> transformEntities(List<NSEVolumeSpurtDetailEntity> nseVolumeSpurtDetailEntities){
        List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels = new ArrayList();
        for (NSEVolumeSpurtDetailEntity nseVolumeSpurtDetailEntity: nseVolumeSpurtDetailEntities) {
            NSEVolumeSpurtDetailModel nseVolumeSpurtDetailModel = new NSEVolumeSpurtDetailModel();

            nseVolumeSpurtDetailModel.setStockDivId(nseVolumeSpurtDetailEntity.getId());
            nseVolumeSpurtDetailModel.setVolume(nseVolumeSpurtDetailEntity.getVolume());
            nseVolumeSpurtDetailModel.setOneWeekAverageVolume(nseVolumeSpurtDetailEntity.getOneWeekAverageVolume());
            nseVolumeSpurtDetailModel.setNoOfTimes(nseVolumeSpurtDetailEntity.getNoOfTimes());
            nseVolumeSpurtDetailModel.setSymbol(nseVolumeSpurtDetailEntity.getSymbol());

            nseVolumeSpurtDetailModels.add(nseVolumeSpurtDetailModel);
        }

        return nseVolumeSpurtDetailModels;
    }

}
