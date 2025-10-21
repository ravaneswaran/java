package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.PriceSpurtsPage;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.util.List;

@Service
public class NSEPriceSpurtGTR20Service extends AbstractNSEPriceSpurtService<PriceSpurtsPage>{

    @Override
    public PriceSpurtsPage getWebPage() {
        PriceSpurtsPage priceSpurtsPage = new PriceSpurtsPage();
        priceSpurtsPage.setNsePriceSpurtDetailModels(this.transformEntities(this.getEntities()));
        return priceSpurtsPage;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findPriceSpurtsGTR20();
    }
}
