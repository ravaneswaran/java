package rave.code.nse.web.service;

import rave.code.entity.nse.csv.NSESMEDetailEntity;
import rave.code.nse.web.model.NSESMEDetailModel;
import rave.code.nse.web.model.page.SMEPage;
import rave.code.repository.nse.NSESMEDetailRepository;

import java.util.ArrayList;
import java.util.List;

public class NSESMEService extends AbstractNSEService<NSESMEDetailEntity, SMEPage> {

    private NSESMEDetailRepository nseSMEDetailRepository = new NSESMEDetailRepository();

    public SMEPage getSMEs(){
        List<NSESMEDetailEntity> nseSMEDetailEntities = this.nseSMEDetailRepository.findAll();

        SMEPage smePage = new SMEPage();
        smePage.setSme(true);
        smePage.setModelList(this.transformEntities(nseSMEDetailEntities));

        return smePage;
    }

    private List<NSESMEDetailModel> transformEntities(List<NSESMEDetailEntity> nseSMEDetailEntities){
        List<NSESMEDetailModel> nseSMEDetailModels = new ArrayList();
        for (NSESMEDetailEntity nseSMEDetailEntity: nseSMEDetailEntities) {
            NSESMEDetailModel nseSMEDetailModel = new NSESMEDetailModel();

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
