package rave.code.repository.groww;

import rave.code.entity.groww.HolidayEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import java.util.logging.Logger;

public class HolidayRepository extends AbstractGrowwRepositoryManager<HolidayEntity> {

    private static final Logger LOGGER = Logger.getLogger(HolidayRepository.class.getName());

    public HolidayRepository() {
        this(HolidayEntity.class);
    }

    public HolidayRepository(Class<HolidayEntity> type) {
        super(type);
    }

    public void deleteAll(){
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaDelete<HolidayEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(HolidayEntity.class);
        criteriaDelete.from(HolidayEntity.class);
        this.getEntityManager().getTransaction().begin();
        int noOfDeletes = this.getEntityManager().createQuery(criteriaDelete).executeUpdate();
        this.getEntityManager().getTransaction().commit();;
        LOGGER.info(String.format("%s numbers of HolidayEntities are removed/deleted...", noOfDeletes));
    }
}