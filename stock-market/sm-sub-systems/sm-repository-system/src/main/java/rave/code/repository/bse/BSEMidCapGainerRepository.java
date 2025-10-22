package rave.code.repository.bse;

import rave.code.entity.bse.BSEMidCapGainerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEMidCapGainerRepository extends StockMarketHistoryEnabledRepository<BSEMidCapGainerEntity> {

    public BSEMidCapGainerRepository() {
        this(BSEMidCapGainerEntity.class);
    }

    public BSEMidCapGainerRepository(Class<BSEMidCapGainerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEMidCapGainerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEMidCapGainerEntity bseMidCapGainerEntity : entities) {
            //BSEMidCapGainerEntity fromDB = this.findBy(bseMidCapGainerEntity.getCompanyName());
            if (bseMidCapGainerEntity.isNewEntity()) {
                //String priceMovement = String.format("%s->%s", fromDB.getLastPrice(), bseMidCapGainerEntity.getLastPrice());
                entityManager.persist(bseMidCapGainerEntity);
            } else {
                entityManager.merge(bseMidCapGainerEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEMidCapGainerEntity findBy(String primaryKey) {
        BSEMidCapGainerEntity bseMidCapGainerEntity = super.findBy(primaryKey);
        if (null != bseMidCapGainerEntity) {
            bseMidCapGainerEntity.setNewEntity(false);
        }
        return bseMidCapGainerEntity;
    }

}
