package rave.code.repository.nse.system;

import rave.code.entity.nse.system.NSETradersChoiceDetailEntity;
import rave.code.repository.nse.AbstractNSERepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class NSETradersChoiceDetailRepository extends AbstractNSERepositoryManager<NSETradersChoiceDetailEntity> {

    public NSETradersChoiceDetailRepository() {
        super(NSETradersChoiceDetailEntity.class);
    }

    @Override
    public List<NSETradersChoiceDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
