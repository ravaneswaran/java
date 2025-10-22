package rave.code.repository.bse;

import rave.code.entity.bse.BSEPriceShockerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEPriceShockerRepository extends StockMarketHistoryEnabledRepository<BSEPriceShockerEntity> {

    public BSEPriceShockerRepository() {
        this(BSEPriceShockerEntity.class);
    }

    public BSEPriceShockerRepository(Class<BSEPriceShockerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEPriceShockerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEPriceShockerEntity bsePriceShockerEntity : entities) {
            if (bsePriceShockerEntity.isNewEntity()) {
                entityManager.persist(bsePriceShockerEntity);
            } else {
                entityManager.merge(bsePriceShockerEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEPriceShockerEntity findBy(String primaryKey) {
        BSEPriceShockerEntity bsePriceShockerEntity = super.findBy(primaryKey);
        if (null != bsePriceShockerEntity) {
            bsePriceShockerEntity.setNewEntity(false);
        }
        return bsePriceShockerEntity;
    }

}
