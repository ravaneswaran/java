package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.nse.web.model.NSEPriceSpurtDetailModel;
import rave.code.nse.web.model.page.PriceSpurtsPage;
import rave.code.repository.nse.NSEPriceSpurtDetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NSEPriceSpurtService extends AbstractNSEService<NSEPriceSpurtDetailEntity, PriceSpurtsPage> {

    NSEPriceSpurtDetailRepository nsePriceSpurtDetailRepository = new NSEPriceSpurtDetailRepository();

    public PriceSpurtsPage getWebPageModel() {
        List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities = this.nsePriceSpurtDetailRepository.findAll();
        PriceSpurtsPage priceSpurtPage = new PriceSpurtsPage();
        priceSpurtPage.setModelList(this.transformEntities(nsePriceSpurtDetailEntities));
        return priceSpurtPage;
    }

    public PriceSpurtsPage getPriceSpurtsLWR20() {
        List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities = this.nsePriceSpurtDetailRepository.findPriceSpurtsLWR20();
        PriceSpurtsPage priceSpurtPage = new PriceSpurtsPage();
        priceSpurtPage.setModelList(this.transformEntities(nsePriceSpurtDetailEntities));
        return priceSpurtPage;
    }

    public PriceSpurtsPage getPriceSpurtsGTR20() {
        List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities = this.nsePriceSpurtDetailRepository.findPriceSpurtsGTR20();
        PriceSpurtsPage priceSpurtPage = new PriceSpurtsPage();
        priceSpurtPage.setModelList(this.transformEntities(nsePriceSpurtDetailEntities));
        return priceSpurtPage;
    }

    private List<NSEPriceSpurtDetailModel> transformEntities(List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities){
        List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels = new ArrayList();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity: nsePriceSpurtDetailEntities) {
            NSEPriceSpurtDetailModel nsePriceSpurtDetailModel = new NSEPriceSpurtDetailModel();

            nsePriceSpurtDetailModel.setStockDivId(nsePriceSpurtDetailEntity.getId());
            nsePriceSpurtDetailModel.setSymbol(nsePriceSpurtDetailEntity.getSymbol());
            nsePriceSpurtDetailModel.setOpenPrice(nsePriceSpurtDetailEntity.getOpenPrice());
            nsePriceSpurtDetailModel.setHighPrice(nsePriceSpurtDetailEntity.getHighPrice());
            nsePriceSpurtDetailModel.setLowPrice(nsePriceSpurtDetailEntity.getLowPrice());
            nsePriceSpurtDetailModel.setPreviousClosePrice(nsePriceSpurtDetailEntity.getPreviousClosePrice());
            nsePriceSpurtDetailModel.setPercentageChange(nsePriceSpurtDetailEntity.getPercentageChange());
            nsePriceSpurtDetailModel.setLastTradedPrice(nsePriceSpurtDetailEntity.getLastTradedPrice());
            nsePriceSpurtDetailModel.setValue(nsePriceSpurtDetailEntity.getValue());
            nsePriceSpurtDetailModel.setVolume(nsePriceSpurtDetailEntity.getVolume());

            nsePriceSpurtDetailModels.add(nsePriceSpurtDetailModel);
        }

        return nsePriceSpurtDetailModels;
    }
}
