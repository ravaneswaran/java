package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;

import java.util.Map;

public class NSEPreOpenMarketDetailRepository extends AbstractNSERepository<NSEPreOpenMarketDetailEntity> {

    public NSEPreOpenMarketDetailRepository() {
        super(NSEPreOpenMarketDetailEntity.class);
    }

    @Override
    public Map<String, NSEPreOpenMarketDetailEntity> getEntityMap() {
        return null;
    }
}
