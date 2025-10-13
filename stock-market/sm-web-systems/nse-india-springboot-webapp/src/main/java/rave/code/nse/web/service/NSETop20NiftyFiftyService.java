package rave.code.nse.web.service;

import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.nse.web.model.NSETop20NiftyFiftyModel;
import rave.code.nse.web.model.page.Top20NiftyFiftyPage;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

public class NSETop20NiftyFiftyService extends AbstractNSEService<NSETop20DetailEntity, Top20NiftyFiftyPage> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public Top20NiftyFiftyPage getTop20NiftyFifty() {
        Top20NiftyFiftyPage top20NiftyFiftyPage = new Top20NiftyFiftyPage();
        top20NiftyFiftyPage.setModelList(this.transformEntities(this.nseTop20DetailRepository.findAll()));

        return top20NiftyFiftyPage;
    }

    private List<NSETop20NiftyFiftyModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20NiftyFiftyModel> nseTop20NiftyFiftyModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20NiftyFiftyModel nseTop20NiftyFiftyModel = new NSETop20NiftyFiftyModel();

            nseTop20NiftyFiftyModel.setHighPrice(nseTop20DetailEntity.getHighPrice());
            nseTop20NiftyFiftyModel.setLastTradedPrice(nseTop20DetailEntity.getLastTradedPrice());
            nseTop20NiftyFiftyModel.setLowPrice(nseTop20DetailEntity.getLowPrice());
            nseTop20NiftyFiftyModel.setOpenPrice(nseTop20DetailEntity.getOpenPrice());
            nseTop20NiftyFiftyModel.setSymbol(nseTop20DetailEntity.getSymbol());
            nseTop20NiftyFiftyModel.setPercentageChange(nseTop20DetailEntity.getPercentageChange());
            nseTop20NiftyFiftyModel.setPreviousClosePrice(nseTop20DetailEntity.getPreviousClosePrice());
            nseTop20NiftyFiftyModel.setVolumeInShares(nseTop20DetailEntity.getVolumeInShares());
            nseTop20NiftyFiftyModel.setValueInLakhs(nseTop20DetailEntity.getValueInLakhs());


            nseTop20NiftyFiftyModels.add(nseTop20NiftyFiftyModel);
        }
        return nseTop20NiftyFiftyModels;
    }
}
