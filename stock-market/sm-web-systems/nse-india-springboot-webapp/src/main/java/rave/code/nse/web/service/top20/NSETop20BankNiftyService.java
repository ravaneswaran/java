package rave.code.nse.web.service.top20;

import org.springframework.stereotype.Service;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.page.top20.Top20BankNiftyPage;
import rave.code.data.model.web.nse.top20.NSETop20BankNiftyModel;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSETop20BankNiftyService extends AbstractNSETop20Service<NSETop20BankNiftyModel> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public NSEWebPage getWebPageModel() {
        Top20BankNiftyPage top20BankNiftyPage = new Top20BankNiftyPage();
        top20BankNiftyPage.setModelList(this.transformEntities(this.nseTop20DetailRepository.findTop20BankNifty()));

        return top20BankNiftyPage;
    }

    public List<NSETop20BankNiftyModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20BankNiftyModel> nseTop20BankNiftyModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity : nseTop20DetailEntities) {
            NSETop20BankNiftyModel nseTop20BankNiftyModel = new NSETop20BankNiftyModel();

            nseTop20BankNiftyModel.setStockDivId(nseTop20DetailEntity.getId());
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
