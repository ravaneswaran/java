package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.PriceSpurtsWebPage;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.util.Comparator;
import java.util.List;

@Service
public class NSEPriceSpurtGTR20Service extends AbstractNSEPriceSpurtService<PriceSpurtsWebPage>{

    @Override
    public PriceSpurtsWebPage getWebPage() {
        List<NSEPriceSpurtDetailEntity> entities = this.getEntities().stream().sorted(Comparator.comparing(NSEPriceSpurtDetailEntity::getOpenPrice)).toList();
        PriceSpurtsWebPage priceSpurtsWebPage = new PriceSpurtsWebPage();
        priceSpurtsWebPage.setNsePriceSpurtDetailModels(this.transformEntities(entities));
        return priceSpurtsWebPage;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findDistinctOpenPricePriceSpurtDetails().stream().filter(nsePriceSpurtDetailEntity -> "STOCK-PRICE>20".equals(nsePriceSpurtDetailEntity.getSpurtType())).toList();
    }
}
