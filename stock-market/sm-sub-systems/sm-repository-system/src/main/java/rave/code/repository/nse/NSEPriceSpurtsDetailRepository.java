package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtsDetailEntity;

import java.util.Map;

public class NSEPriceSpurtsDetailRepository extends AbstractNSERepository<NSEPriceSpurtsDetailEntity> {

    public NSEPriceSpurtsDetailRepository() {
        super(NSEPriceSpurtsDetailEntity.class);
    }

    @Override
    public Map<String, NSEPriceSpurtsDetailEntity> getEntityMap() {
        return null;
    }
}
