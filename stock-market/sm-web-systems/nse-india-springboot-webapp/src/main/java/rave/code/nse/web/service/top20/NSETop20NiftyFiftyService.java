package rave.code.nse.web.service.top20;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.top20.Top20NiftyFiftyPage;
import rave.code.data.model.web.nse.page.top20.Top20NiftyNextFiftyPage;
import rave.code.data.model.web.nse.top20.NSETop20NiftyFiftyModel;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSETop20NiftyFiftyService extends AbstractNSETop20Service<NSETop20NiftyFiftyModel, Top20NiftyFiftyPage> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    @Override
    public Top20NiftyFiftyPage getWebPage() {
        Top20NiftyFiftyPage top20NiftyFiftyPage = new Top20NiftyFiftyPage();
        top20NiftyFiftyPage.setNseTop20NiftyFiftyModels(this.transformEntities(this.getEntities()));
        return top20NiftyFiftyPage;
    }

    @Override
    public List<NSETop20DetailEntity> getEntities() {
        return this.nseTop20DetailRepository.findTop20NiftyFifty();
    }

    public List<NSETop20NiftyFiftyModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20NiftyFiftyModel> nseTop20NiftyFiftyModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20NiftyFiftyModel nseTop20NiftyFiftyModel = new NSETop20NiftyFiftyModel();

            nseTop20NiftyFiftyModel.setStockDivId(nseTop20DetailEntity.getId());
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
