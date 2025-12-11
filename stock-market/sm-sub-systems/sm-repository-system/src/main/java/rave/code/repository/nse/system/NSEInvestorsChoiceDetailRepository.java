package rave.code.repository.nse.system;

import rave.code.entity.nse.system.NSEInvestorsChoiceDetailEntity;
import rave.code.repository.nse.AbstractNSERepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class NSEInvestorsChoiceDetailRepository extends AbstractNSERepositoryManager<NSEInvestorsChoiceDetailEntity> {

    public NSEInvestorsChoiceDetailRepository() {
        super(NSEInvestorsChoiceDetailEntity.class);
    }

    @Override
    public List<NSEInvestorsChoiceDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
