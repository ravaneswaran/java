package rave.code.nse.web.service.top20;

import org.springframework.stereotype.Service;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.data.model.web.nse.page.NSEWebPage;
import rave.code.data.model.web.nse.page.top20.Top20SecuritiesGTR20Page;
import rave.code.data.model.web.nse.top20.NSETop20SecurityGTR20Model;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSETop20SecuritiesGtr20Service extends AbstractNSETop20Service<NSETop20SecurityGTR20Model> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public NSEWebPage getWebPageModel() {
        Top20SecuritiesGTR20Page top20SecuritiesGTR20Page = new Top20SecuritiesGTR20Page();
        top20SecuritiesGTR20Page.setModelList(this.transformEntities(this.nseTop20DetailRepository.findTop20SecurityGTR20()));

        return top20SecuritiesGTR20Page;
    }

    public List<NSETop20SecurityGTR20Model> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20SecurityGTR20Model> nseTop20SecurityGTR20Models = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity : nseTop20DetailEntities) {
            NSETop20SecurityGTR20Model nseTop20SecurityGTR20Model = new NSETop20SecurityGTR20Model();

            nseTop20SecurityGTR20Model.setStockDivId(nseTop20DetailEntity.getId());
            nseTop20SecurityGTR20Model.setHighPrice(nseTop20DetailEntity.getHighPrice());
            nseTop20SecurityGTR20Model.setLastTradedPrice(nseTop20DetailEntity.getLastTradedPrice());
            nseTop20SecurityGTR20Model.setLowPrice(nseTop20DetailEntity.getLowPrice());
            nseTop20SecurityGTR20Model.setOpenPrice(nseTop20DetailEntity.getOpenPrice());
            nseTop20SecurityGTR20Model.setSymbol(nseTop20DetailEntity.getSymbol());
            nseTop20SecurityGTR20Model.setPercentageChange(nseTop20DetailEntity.getPercentageChange());
            nseTop20SecurityGTR20Model.setPreviousClosePrice(nseTop20DetailEntity.getPreviousClosePrice());
            nseTop20SecurityGTR20Model.setVolumeInShares(nseTop20DetailEntity.getVolumeInShares());
            nseTop20SecurityGTR20Model.setValueInLakhs(nseTop20DetailEntity.getValueInLakhs());

            nseTop20SecurityGTR20Models.add(nseTop20SecurityGTR20Model);
        }
        return nseTop20SecurityGTR20Models;
    }
}