package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEVolumeSpurtDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class NSEVolumeSpurtDetailRepository extends AbstractNSERepositoryManager<NSEVolumeSpurtDetailEntity> {

    public NSEVolumeSpurtDetailRepository() {
        super(NSEVolumeSpurtDetailEntity.class);
    }

    @Override
    public List<NSEVolumeSpurtDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
