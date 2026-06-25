package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.PriceSpurtsWebPage;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.util.Comparator;
import java.util.List;

@Service
public class NSEPriceSpurtService extends AbstractNSEPriceSpurtService<PriceSpurtsWebPage> {

    @Override
    public PriceSpurtsWebPage getWebPage() {
        List<NSEPriceSpurtDetailEntity> entities = this.getEntities();
        entities.sort(Comparator.comparing(NSEPriceSpurtDetailEntity::getOpenPrice));
        PriceSpurtsWebPage priceSpurtsWebPage = new PriceSpurtsWebPage();
        priceSpurtsWebPage.setPriceSpurt(false);
        priceSpurtsWebPage.setNsePriceSpurtDetailModels(this.transformEntities(entities));
        priceSpurtsWebPage.setNseStockModels(this.getNSEStockModels(entities));
        return priceSpurtsWebPage;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findTodayDistinctPriceSpurtDetails();
    }
}
