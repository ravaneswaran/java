package rave.code.repository.groww;

import rave.code.entity.groww.HolidayEntity;

import java.util.logging.Logger;

public class HolidayRepository extends AbstractGrowwRepositoryManager<HolidayEntity> {

    private static final Logger LOGGER = Logger.getLogger(HolidayRepository.class.getName());

    public HolidayRepository() {
        this(HolidayEntity.class);
    }

    public HolidayRepository(Class<HolidayEntity> type) {
        super(type);
    }
}