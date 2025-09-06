package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEVolumeSpurtsDetailEntity;

import java.util.Map;

public class NSEVolumeSpurtsDetailRepository extends AbstractNSERepository<NSEVolumeSpurtsDetailEntity> {


    public NSEVolumeSpurtsDetailRepository() {
        super(NSEVolumeSpurtsDetailEntity.class);
    }

    @Override
    public Map<String, NSEVolumeSpurtsDetailEntity> getEntityMap() {
        return null;
    }
}
