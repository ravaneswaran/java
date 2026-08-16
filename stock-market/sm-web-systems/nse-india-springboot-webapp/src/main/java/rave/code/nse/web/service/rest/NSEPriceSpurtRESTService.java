package rave.code.nse.web.service.rest;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.nse.web.service.AbstractNSEPriceSpurtService;

import java.util.List;
import java.util.Map;

@Service
public class NSEPriceSpurtRESTService<MarketOnOpenWebPage> extends AbstractNSEPriceSpurtService<MarketOnOpenWebPage> {

    @Override
    public MarketOnOpenWebPage getWebPage() {
        return null;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findDistinctNSEPricePriceSpurtDetails();
    }

    @Override
    public List<NSEPriceSpurtDetailModel> transformEntities(List<NSEPriceSpurtDetailEntity> entities) {
        return super.transformEntities(entities);
    }

    @Override
    public Map<String, List<NSEPriceSpurtDetailEntity>> getMappedEntities() {
        return null;
    }
}
