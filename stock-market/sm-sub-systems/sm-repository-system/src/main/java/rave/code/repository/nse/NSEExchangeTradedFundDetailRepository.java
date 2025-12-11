package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEExchangeTradedFundDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class NSEExchangeTradedFundDetailRepository extends AbstractNSERepositoryManager<NSEExchangeTradedFundDetailEntity> {

    public NSEExchangeTradedFundDetailRepository() {
        super(NSEExchangeTradedFundDetailEntity.class);
    }

    @Override
    public List<NSEExchangeTradedFundDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
