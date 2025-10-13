package rave.code.nse.web.service;

import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.nse.web.model.NSETop20FOSecurityModel;
import rave.code.nse.web.model.page.Top20FOSecurityPage;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

public class NSETop20FOSecurityService extends AbstractNSEService<NSETop20DetailEntity, Top20FOSecurityPage> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public Top20FOSecurityPage getTop20FOSecurities() {
        Top20FOSecurityPage top20FOSecurityPage = new Top20FOSecurityPage();
        top20FOSecurityPage.setModelList(this.transformEntities(this.nseTop20DetailRepository.findTop20FOSecurities()));

        return top20FOSecurityPage;
    }

    private List<NSETop20FOSecurityModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20FOSecurityModel> nseTop20FOSecurityModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20FOSecurityModel nseTop20FOSecurityModel = new NSETop20FOSecurityModel();

            nseTop20FOSecurityModel.setHighPrice(nseTop20DetailEntity.getHighPrice());
            nseTop20FOSecurityModel.setLastTradedPrice(nseTop20DetailEntity.getLastTradedPrice());
            nseTop20FOSecurityModel.setLowPrice(nseTop20DetailEntity.getLowPrice());
            nseTop20FOSecurityModel.setOpenPrice(nseTop20DetailEntity.getOpenPrice());
            nseTop20FOSecurityModel.setSymbol(nseTop20DetailEntity.getSymbol());
            nseTop20FOSecurityModel.setPercentageChange(nseTop20DetailEntity.getPercentageChange());
            nseTop20FOSecurityModel.setPreviousClosePrice(nseTop20DetailEntity.getPreviousClosePrice());
            nseTop20FOSecurityModel.setVolumeInShares(nseTop20DetailEntity.getVolumeInShares());
            nseTop20FOSecurityModel.setValueInLakhs(nseTop20DetailEntity.getValueInLakhs());

            nseTop20FOSecurityModels.add(nseTop20FOSecurityModel);
        }
        return nseTop20FOSecurityModels;
    }

}
