package rave.code.repository.nse;

import rave.code.entity.nse.NSEDayPriceLastRunDetailEntity;
import rave.code.repository.AbstractOneEntityRepositoryManager;

import javax.persistence.EntityManager;

public class NSEDayPriceLastRunDetailRepository extends AbstractOneEntityRepositoryManager<NSEDayPriceLastRunDetailEntity> {

    public NSEDayPriceLastRunDetailRepository() {
        super(NSEDayPriceLastRunDetailEntity.class);
    }

    public NSEDayPriceLastRunDetailEntity upsert(NSEDayPriceLastRunDetailEntity entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        if (entity.isNewEntity()) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.getTransaction().commit();
        return entity;
    }
}
