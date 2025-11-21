package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceToEarningRatioDetailEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NSEPriceToEarningRatioDetailRepository extends AbstractNSERepositoryManager<NSEPriceToEarningRatioDetailEntity> {

    public NSEPriceToEarningRatioDetailRepository() {
        super(NSEPriceToEarningRatioDetailEntity.class);
    }

    @Override
    public Map<String, NSEPriceToEarningRatioDetailEntity> getEntityMap() {
        List<NSEPriceToEarningRatioDetailEntity> nsePriceToEarningRatioDetailEntities = this.findAll();
        Map<String, NSEPriceToEarningRatioDetailEntity> entityMap = new HashMap<>();

        for (NSEPriceToEarningRatioDetailEntity entity : nsePriceToEarningRatioDetailEntities) {
            String symbol = entity.getSymbol();
            entityMap.put(symbol, entity);
        }

        return entityMap;
    }
}
