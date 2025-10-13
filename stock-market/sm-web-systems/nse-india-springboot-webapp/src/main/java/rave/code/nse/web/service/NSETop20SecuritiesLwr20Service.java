package rave.code.nse.web.service;

import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.nse.web.model.NSETop20SecurityLWR20Model;
import rave.code.nse.web.model.page.Top20SecuritiesLWR20Page;
import rave.code.repository.nse.NSETop20DetailRepository;

import java.util.ArrayList;
import java.util.List;

public class NSETop20SecuritiesLwr20Service extends AbstractNSEService<NSETop20DetailEntity, Top20SecuritiesLWR20Page> {

    private NSETop20DetailRepository nseTop20DetailRepository = new NSETop20DetailRepository();

    public Top20SecuritiesLWR20Page getTop20SecuritiesLwr20() {
        Top20SecuritiesLWR20Page top20SecuritiesLWR20Page = new Top20SecuritiesLWR20Page();
        top20SecuritiesLWR20Page.setModelList(this.transformEntities(this.nseTop20DetailRepository.findTop20SecurityLWR20()));

        return top20SecuritiesLWR20Page;
    }

    private List<NSETop20SecurityLWR20Model> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities) {
        List<NSETop20SecurityLWR20Model> nseTop20SecurityLWR20Models = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: nseTop20DetailEntities){
            NSETop20SecurityLWR20Model nseTop20SecurityLWR20Model = new NSETop20SecurityLWR20Model();

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
