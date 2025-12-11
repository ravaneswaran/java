package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEDayShortSellDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class NSEDayShortSellDetailRepository extends AbstractNSERepositoryManager<NSEDayShortSellDetailEntity> {

    public NSEDayShortSellDetailRepository() {
        super(NSEDayShortSellDetailEntity.class);
    }

    @Override
    public List<NSEDayShortSellDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}