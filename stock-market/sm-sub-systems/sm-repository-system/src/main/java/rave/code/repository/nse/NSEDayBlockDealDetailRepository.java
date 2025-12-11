package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEDayBlockDealDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class NSEDayBlockDealDetailRepository extends AbstractNSERepositoryManager<NSEDayBlockDealDetailEntity> {

    public NSEDayBlockDealDetailRepository() {
        super(NSEDayBlockDealDetailEntity.class);
    }

    @Override
    public List<NSEDayBlockDealDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
