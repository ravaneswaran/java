package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSESMEDetailModel;
import rave.code.data.model.web.nse.page.SMEWebPage;
import rave.code.entity.nse.csv.NSESMEDetailEntity;
import rave.code.repository.nse.NSESMEDetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSESMEService extends AbstractNSEService<NSESMEDetailEntity, NSESMEDetailModel, SMEWebPage> {

    private NSESMEDetailRepository nseSMEDetailRepository = new NSESMEDetailRepository();

    @Override
    public SMEWebPage getWebPage() {
        SMEWebPage smePage = new SMEWebPage();
        smePage.setNseSMEDetailModels(this.transformEntities(this.getEntities()));
        return smePage;
    }

    @Override
    public List<NSESMEDetailEntity> getEntities() {
        return this.nseSMEDetailRepository.findAll();
    }

    @Override
    public List<NSESMEDetailModel> transformEntities(List<NSESMEDetailEntity> entities){
        List<NSESMEDetailModel> nseSMEDetailModels = new ArrayList();
        for (NSESMEDetailEntity nseSMEDetailEntity: entities) {
            NSESMEDetailModel nseSMEDetailModel = new NSESMEDetailModel();

            nseSMEDetailModel.setStockDivId(nseSMEDetailEntity.getId());
            nseSMEDetailModel.setSymbol(nseSMEDetailEntity.getSymbol());
            nseSMEDetailModel.setHighPrice(nseSMEDetailEntity.getHighPrice());
            nseSMEDetailModel.setVolume(nseSMEDetailEntity.getVolume());
            nseSMEDetailModel.setLowPrice(nseSMEDetailEntity.getLowPrice());
            nseSMEDetailModel.setLastTradedPrice(nseSMEDetailEntity.getLastTradedPrice());
            nseSMEDetailModel.setOpenPrice(nseSMEDetailEntity.getOpenPrice());
            nseSMEDetailModel.setPercentageChange(nseSMEDetailEntity.getPercentageChange());
            nseSMEDetailModel.setValueInLakhs(nseSMEDetailEntity.getValueInLakhs());
            nseSMEDetailModel.setPreviousClosePrice(nseSMEDetailEntity.getPreviousClosePrice());

            nseSMEDetailModels.add(nseSMEDetailModel);
        }

        return nseSMEDetailModels;
    }

}
