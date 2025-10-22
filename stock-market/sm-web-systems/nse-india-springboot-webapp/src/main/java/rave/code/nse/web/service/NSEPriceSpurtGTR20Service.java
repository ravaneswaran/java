package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.PriceSpurtsWebPage;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.util.List;

@Service
public class NSEPriceSpurtGTR20Service extends AbstractNSEPriceSpurtService<PriceSpurtsWebPage>{

    @Override
    public PriceSpurtsWebPage getWebPage() {
        PriceSpurtsWebPage priceSpurtsPage = new PriceSpurtsWebPage();
        priceSpurtsPage.setNsePriceSpurtDetailModels(this.transformEntities(this.getEntities()));
        return priceSpurtsPage;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findPriceSpurtsGTR20();
    }
}
