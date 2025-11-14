package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.data.model.web.nse.NSEVolumeSpurtDetailModel;
import rave.code.data.model.web.nse.page.VolumeSpurtsWebPage;
import rave.code.entity.nse.csv.NSESMEDetailEntity;
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
        List<NSEVolumeSpurtDetailEntity> entities = this.getEntities();
        VolumeSpurtsWebPage volumeSpurtsWebPage = new VolumeSpurtsWebPage();
        volumeSpurtsWebPage.setNseVolumeSpurtDetailModels(this.transformEntities(entities));
        volumeSpurtsWebPage.setNseStockModels(this.getNSEStockModels(entities));
        return volumeSpurtsWebPage;
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

    @Override
    public List<NSEStockModel> getNSEStockModels(List<NSEVolumeSpurtDetailEntity> entities) {
        return new ArrayList<>();
    }
}
