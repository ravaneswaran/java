package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSEVolumeSpurtDetailModel;
import rave.code.data.model.web.nse.page.VolumeSpurtsWebPage;
import rave.code.entity.nse.csv.NSEVolumeSpurtDetailEntity;
import rave.code.repository.nse.NSEVolumeSpurtDetailRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class NSEVolumeSpurtsService extends AbstractNSEService<NSEVolumeSpurtDetailEntity, NSEVolumeSpurtDetailModel, VolumeSpurtsWebPage> {

    private NSEVolumeSpurtDetailRepository nseVolumeSpurtDetailRepository = new NSEVolumeSpurtDetailRepository();

    @Override
    public VolumeSpurtsWebPage getWebPage() {
        VolumeSpurtsWebPage volumeSpurtsPage = new VolumeSpurtsWebPage();
        volumeSpurtsPage.setNseVolumeSpurtDetailModels(this.transformEntities(this.getEntities()));
        return volumeSpurtsPage;
    }

    @Override
    public List<NSEVolumeSpurtDetailEntity> getEntities() {
        return this.nseVolumeSpurtDetailRepository.findAll();
    }

    @Override
    public List<NSEVolumeSpurtDetailModel> transformEntities(List<NSEVolumeSpurtDetailEntity> entities){
        List<NSEVolumeSpurtDetailModel> nseVolumeSpurtDetailModels = new ArrayList();
        for (NSEVolumeSpurtDetailEntity nseVolumeSpurtDetailEntity: entities) {
            NSEVolumeSpurtDetailModel nseVolumeSpurtDetailModel = new NSEVolumeSpurtDetailModel();

            nseVolumeSpurtDetailModel.setStockDivId(nseVolumeSpurtDetailEntity.getId());
            nseVolumeSpurtDetailModel.setVolume(nseVolumeSpurtDetailEntity.getVolume());
            nseVolumeSpurtDetailModel.setOneWeekAverageVolume(nseVolumeSpurtDetailEntity.getOneWeekAverageVolume());
            double noOfTimes = new BigDecimal(nseVolumeSpurtDetailEntity.getNoOfTimes()).setScale(3, RoundingMode.HALF_UP).doubleValue();
            nseVolumeSpurtDetailModel.setNoOfTimes(noOfTimes);
            nseVolumeSpurtDetailModel.setSymbol(nseVolumeSpurtDetailEntity.getSymbol());

            nseVolumeSpurtDetailModels.add(nseVolumeSpurtDetailModel);
        }

        return nseVolumeSpurtDetailModels;
    }

}
