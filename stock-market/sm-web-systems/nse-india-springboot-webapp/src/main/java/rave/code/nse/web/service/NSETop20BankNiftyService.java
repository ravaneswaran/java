package rave.code.nse.web.service;

import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.nse.web.model.NSETop20BankNiftyModel;
import rave.code.nse.web.model.NSETop20SecurityGTR20Model;
import rave.code.nse.web.model.page.Top20BankNiftyPage;
import rave.code.nse.web.model.page.Top20SecuritiesGTR20Page;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

public class NSETop20BankNiftyService extends AbstractNSEService<NSETop20DetailEntity, Top20BankNiftyPage> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public Top20BankNiftyPage getTop20BankNifty() {
        Top20BankNiftyPage top20BankNiftyPage = new Top20BankNiftyPage();
        top20BankNiftyPage.setModelList(this.transformEntities(this.nseTop20DetailRepository.findTop20BankNifty()));

        return top20BankNiftyPage;
    }

    private List<NSETop20BankNiftyModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20BankNiftyModel> nseTop20BankNiftyModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity : nseTop20DetailEntities) {
            NSETop20BankNiftyModel nseTop20BankNiftyModel = new NSETop20BankNiftyModel();

            nseTop20BankNiftyModel.setHighPrice(nseTop20DetailEntity.getHighPrice());
            nseTop20BankNiftyModel.setLastTradedPrice(nseTop20DetailEntity.getLastTradedPrice());
            nseTop20BankNiftyModel.setLowPrice(nseTop20DetailEntity.getLowPrice());
            nseTop20BankNiftyModel.setOpenPrice(nseTop20DetailEntity.getOpenPrice());
            nseTop20BankNiftyModel.setSymbol(nseTop20DetailEntity.getSymbol());
            nseTop20BankNiftyModel.setPercentageChange(nseTop20DetailEntity.getPercentageChange());
            nseTop20BankNiftyModel.setPreviousClosePrice(nseTop20DetailEntity.getPreviousClosePrice());
            nseTop20BankNiftyModel.setVolumeInShares(nseTop20DetailEntity.getVolumeInShares());
            nseTop20BankNiftyModel.setValueInLakhs(nseTop20DetailEntity.getValueInLakhs());

            nseTop20BankNiftyModels.add(nseTop20BankNiftyModel);
        }
        return nseTop20BankNiftyModels;
    }
}
