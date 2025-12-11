package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEDayBulkDealDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class NSEDayBulkDealDetailRepository extends AbstractNSERepositoryManager<NSEDayBulkDealDetailEntity> {

    public NSEDayBulkDealDetailRepository() {
        super(NSEDayBulkDealDetailEntity.class);
    }

    @Override
    public List<NSEDayBulkDealDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
