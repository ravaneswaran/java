package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEMainBoardDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class NSEMainBoardDetailRepository extends AbstractNSERepositoryManager<NSEMainBoardDetailEntity> {

    public NSEMainBoardDetailRepository() {
        super(NSEMainBoardDetailEntity.class);
    }

    @Override
    public List<NSEMainBoardDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
