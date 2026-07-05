package rave.code.repository.nse;

import rave.code.entity.nse.technical.NSESimpleMovingAverageDetailEntity;

import java.util.List;

public class NSESimpleMovingAverageDetailRepository extends AbstractNSERepositoryManager<NSESimpleMovingAverageDetailEntity>{

    public NSESimpleMovingAverageDetailRepository() {
        super(NSESimpleMovingAverageDetailEntity.class);
    }

    @Override
    public List<NSESimpleMovingAverageDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }
}
