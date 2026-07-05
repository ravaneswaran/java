package rave.code.repository.nse;

import rave.code.entity.nse.technical.NSEExponentialMovingAverageDetailEntity;

import java.util.List;

public class NSEExponentialMovingAverageDetailRepository extends AbstractNSERepositoryManager<NSEExponentialMovingAverageDetailEntity>{

    public NSEExponentialMovingAverageDetailRepository() {
        super(NSEExponentialMovingAverageDetailEntity.class);
    }

    @Override
    public List<NSEExponentialMovingAverageDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }
}
