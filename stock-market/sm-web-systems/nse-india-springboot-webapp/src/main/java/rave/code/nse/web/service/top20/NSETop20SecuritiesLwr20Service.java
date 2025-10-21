package rave.code.nse.web.service.top20;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.top20.Top20SecuritiesLWR20Page;
import rave.code.data.model.web.nse.top20.NSETop20SecurityLWR20Model;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSETop20SecuritiesLwr20Service extends AbstractNSETop20Service<NSETop20SecurityLWR20Model, Top20SecuritiesLWR20Page> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    @Override
    public Top20SecuritiesLWR20Page getWebPage() {
        Top20SecuritiesLWR20Page top20SecuritiesLWR20Page = new Top20SecuritiesLWR20Page();
        top20SecuritiesLWR20Page.setNseTop20SecurityLWR20Models(this.transformEntities(this.getEntities()));
        return top20SecuritiesLWR20Page;
    }

    @Override
    public List<NSETop20DetailEntity> getEntities() {
        return this.nseTop20DetailRepository.findTop20SecurityLWR20();
    }

    public List<NSETop20SecurityLWR20Model> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20SecurityLWR20Model> nseTop20SecurityLWR20Models = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20SecurityLWR20Model nseTop20SecurityLWR20Model = new NSETop20SecurityLWR20Model();

            nseTop20SecurityLWR20Model.setStockDivId(nseTop20DetailEntity.getId());
            nseTop20SecurityLWR20Model.setHighPrice(nseTop20DetailEntity.getHighPrice());
            nseTop20SecurityLWR20Model.setLastTradedPrice(nseTop20DetailEntity.getLastTradedPrice());
            nseTop20SecurityLWR20Model.setLowPrice(nseTop20DetailEntity.getLowPrice());
            nseTop20SecurityLWR20Model.setOpenPrice(nseTop20DetailEntity.getOpenPrice());
            nseTop20SecurityLWR20Model.setSymbol(nseTop20DetailEntity.getSymbol());
            nseTop20SecurityLWR20Model.setPercentageChange(nseTop20DetailEntity.getPercentageChange());
            nseTop20SecurityLWR20Model.setPreviousClosePrice(nseTop20DetailEntity.getPreviousClosePrice());
            nseTop20SecurityLWR20Model.setVolumeInShares(nseTop20DetailEntity.getVolumeInShares());
            nseTop20SecurityLWR20Model.setValueInLakhs(nseTop20DetailEntity.getValueInLakhs());

            nseTop20SecurityLWR20Models.add(nseTop20SecurityLWR20Model);
        }
        return nseTop20SecurityLWR20Models;
    }
}
