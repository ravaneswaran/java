package rave.code.repository.groww;

import rave.code.entity.groww.HolidayEntity;

import java.util.List;

public class HolidayRepository extends AbstractGrowwRepositoryManager<HolidayEntity> {

    public HolidayRepository() {
        this(HolidayEntity.class);
    }

    public HolidayRepository(Class<HolidayEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<HolidayEntity> entities) {
        throw new RuntimeException("Implementation not required....");
    }
}