package rave.code.repository.bse;

import rave.code.entity.bse.BSEVolumeShockerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEVolumeShockerRepository extends StockMarketHistoryEnabledRepository<BSEVolumeShockerEntity> {

    public BSEVolumeShockerRepository() {
        this(BSEVolumeShockerEntity.class);
    }

    public BSEVolumeShockerRepository(Class<BSEVolumeShockerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEVolumeShockerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEVolumeShockerEntity bseVolumeShockerEntity : entities) {
            if (bseVolumeShockerEntity.isNewEntity()) {
                entityManager.persist(bseVolumeShockerEntity);
            } else {
                entityManager.merge(bseVolumeShockerEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEVolumeShockerEntity findBy(String primaryKey) {
        BSEVolumeShockerEntity bseVolumeShockerEntity = super.findBy(primaryKey);
        if (null != bseVolumeShockerEntity) {
            bseVolumeShockerEntity.setNewEntity(false);
        }
        return bseVolumeShockerEntity;
    }
}
