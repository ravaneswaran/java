package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class NSEPriceSpurtService<MarketOnOpenWebPage> extends AbstractNSEPriceSpurtService<MarketOnOpenWebPage>{

    @Override
    public MarketOnOpenWebPage getWebPage() {
        return null;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return null;
    }

    @Override
    public Map<String, List<NSEPriceSpurtDetailEntity>> getMappedEntities() {
        return this.nsePriceSpurtDetailRepository.findForMarketOnOpen();
    }

    @Override
    public List<NSEPriceSpurtDetailModel> transformEntities(List<NSEPriceSpurtDetailEntity> entities) {
        return super.transformEntities(entities);
    }

    public Map<String, List<NSEPriceSpurtDetailModel>> getMappedModels(){
        Map<String, List<NSEPriceSpurtDetailModel>> returnValue = new HashMap<>();

        Map<String, List<NSEPriceSpurtDetailEntity>> source = this.getMappedEntities();
        Set<String> keys = source.keySet();
        for (String key : keys){
            List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels = this.transformEntities(source.get(key));
            returnValue.put(key, nsePriceSpurtDetailModels);
        }

        return returnValue;
    }
}
