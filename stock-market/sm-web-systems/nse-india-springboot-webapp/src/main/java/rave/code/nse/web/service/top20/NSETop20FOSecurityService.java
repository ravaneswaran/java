package rave.code.nse.web.service.top20;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.top20.Top20FOSecurityPage;
import rave.code.data.model.web.nse.top20.NSETop20FOSecurityModel;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSETop20FOSecurityService extends AbstractNSETop20Service<NSETop20FOSecurityModel, Top20FOSecurityPage> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    @Override
    public Top20FOSecurityPage getWebPage() {
        Top20FOSecurityPage top20FOSecurityPage = new Top20FOSecurityPage();
        top20FOSecurityPage.setNseTop20FOSecurityModels(this.transformEntities(this.getEntities()));
        return top20FOSecurityPage;
    }

    @Override
    public List<NSETop20DetailEntity> getEntities() {
        return this.nseTop20DetailRepository.findTop20FOSecurities();
    }

    public List<NSETop20FOSecurityModel> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20FOSecurityModel> nseTop20FOSecurityModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20FOSecurityModel nseTop20FOSecurityModel = new NSETop20FOSecurityModel();

            nseTop20FOSecurityModel.setStockDivId(nseTop20DetailEntity.getId());
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
