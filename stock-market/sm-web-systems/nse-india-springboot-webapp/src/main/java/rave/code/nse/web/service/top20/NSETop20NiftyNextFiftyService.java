package rave.code.nse.web.service.top20;

import org.springframework.stereotype.Service;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.page.top20.Top20NiftyNextFiftyPage;
import rave.code.data.model.web.nse.top20.NSETop20NiftyNextFiftyModel;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSETop20NiftyNextFiftyService extends AbstractNSETop20Service<NSETop20NiftyNextFiftyModel> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public NSEWebPage getWebPageModel() {
        Top20NiftyNextFiftyPage top20NiftyNextFiftyPage = new Top20NiftyNextFiftyPage();
        top20NiftyNextFiftyPage.setModelList(this.transformEntities(this.nseTop20DetailRepository.findTop20NiftyNext50()));

        return top20NiftyNextFiftyPage;
    }

    public List<NSETop20NiftyNextFiftyModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20NiftyNextFiftyModel> nseTop20NiftyNextFiftyModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20NiftyNextFiftyModel nseTop20NiftyNextFiftyModel = new NSETop20NiftyNextFiftyModel();

            nseTop20NiftyNextFiftyModel.setStockDivId(nseTop20DetailEntity.getId());
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
