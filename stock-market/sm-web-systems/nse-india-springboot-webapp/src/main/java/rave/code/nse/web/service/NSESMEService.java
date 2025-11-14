package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSESMEDetailModel;
import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.data.model.web.nse.page.SMEWebPage;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.entity.nse.csv.NSESMEDetailEntity;
import rave.code.repository.nse.NSESMEDetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSESMEService extends AbstractNSEService<NSESMEDetailEntity, NSESMEDetailModel, SMEWebPage> {

    private NSESMEDetailRepository nseSMEDetailRepository = new NSESMEDetailRepository();

    @Override
    public SMEWebPage getWebPage() {
        List<NSESMEDetailEntity> entities = this.getEntities();
        SMEWebPage smeWebPage = new SMEWebPage();
        smeWebPage.setNseSMEDetailModels(this.transformEntities(entities));
        smeWebPage.setNseStockModels(this.getNSEStockModels(entities));
        return smeWebPage;
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

    @Override
    public List<NSEStockModel> getNSEStockModels(List<NSESMEDetailEntity> entities) {
        List<NSEStockModel> nseStockModels = new ArrayList<>();
        for (NSESMEDetailEntity nseSMEDetailEntity: entities) {
            NSEStockModel nseStockModel = new NSEStockModel();
            nseStockModel.setStockDivId(nseSMEDetailEntity.getId());
            nseStockModel.setSymbol(nseSMEDetailEntity.getSymbol());
            nseStockModel.setPreviousClosePrice(nseSMEDetailEntity.getPreviousClosePrice());
            nseStockModel.setPercentageChange(nseSMEDetailEntity.getPercentageChange());
            nseStockModel.setOpenPrice(nseSMEDetailEntity.getOpenPrice());
            nseStockModels.add(nseStockModel);
        }
        return nseStockModels;
    }

}
