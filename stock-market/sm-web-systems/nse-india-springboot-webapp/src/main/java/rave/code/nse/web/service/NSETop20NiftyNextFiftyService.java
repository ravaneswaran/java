package rave.code.nse.web.service;

import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.nse.web.model.NSETop20NiftyNextFiftyModel;
import rave.code.nse.web.model.page.Top20NiftyNextFiftyPage;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

public class NSETop20NiftyNextFiftyService extends AbstractNSEService<NSETop20DetailEntity, Top20NiftyNextFiftyPage> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public Top20NiftyNextFiftyPage getTop20NiftyNextFifty() {
        Top20NiftyNextFiftyPage top20NiftyNextFiftyPage = new Top20NiftyNextFiftyPage();
        top20NiftyNextFiftyPage.setModelList(this.transformEntities(this.nseTop20DetailRepository.findAll()));

        return top20NiftyNextFiftyPage;
    }

    private List<NSETop20NiftyNextFiftyModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20NiftyNextFiftyModel> nseTop20NiftyNextFiftyModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20NiftyNextFiftyModel nseTop20NiftyNextFiftyModel = new NSETop20NiftyNextFiftyModel();

            nseTop20NiftyNextFiftyModel.setHighPrice(nseTop20DetailEntity.getHighPrice());
            nseTop20NiftyNextFiftyModel.setLastTradedPrice(nseTop20DetailEntity.getLastTradedPrice());
            nseTop20NiftyNextFiftyModel.setLowPrice(nseTop20DetailEntity.getLowPrice());
            nseTop20NiftyNextFiftyModel.setOpenPrice(nseTop20DetailEntity.getOpenPrice());
            nseTop20NiftyNextFiftyModel.setSymbol(nseTop20DetailEntity.getSymbol());
            nseTop20NiftyNextFiftyModel.setPercentageChange(nseTop20DetailEntity.getPercentageChange());
            nseTop20NiftyNextFiftyModel.setPreviousClosePrice(nseTop20DetailEntity.getPreviousClosePrice());
            nseTop20NiftyNextFiftyModel.setVolumeInShares(nseTop20DetailEntity.getVolumeInShares());
            nseTop20NiftyNextFiftyModel.setValueInLakhs(nseTop20DetailEntity.getValueInLakhs());


            nseTop20NiftyNextFiftyModels.add(nseTop20NiftyNextFiftyModel);
        }
        return nseTop20NiftyNextFiftyModels;
    }
}
