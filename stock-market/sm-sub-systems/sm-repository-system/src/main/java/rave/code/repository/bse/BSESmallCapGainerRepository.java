package rave.code.repository.bse;

import rave.code.entity.bse.BSESmallCapGainerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSESmallCapGainerRepository extends StockMarketRepository<BSESmallCapGainerEntity> {

    public BSESmallCapGainerRepository() {
        this(BSESmallCapGainerEntity.class);
    }

    public BSESmallCapGainerRepository(Class<BSESmallCapGainerEntity> type) {
        super(type);
    }

    public void bulkUpsert(List<BSESmallCapGainerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSESmallCapGainerEntity bseSmallCapGainerEntity : entities) {
            //BSESmallCapGainerEntity fromDB = this.findBy(bseSmallCapGainerEntity.getCompanyName());
            if (bseSmallCapGainerEntity.isNewEntity()) {
                //String priceMovement = String.format("%s->%s", fromDB.getLastPrice(), bseSmallCapGainerEntity.getLastPrice());
                entityManager.persist(bseSmallCapGainerEntity);
            } else {
                entityManager.merge(bseSmallCapGainerEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSESmallCapGainerEntity findBy(String primaryKey) {
        BSESmallCapGainerEntity bseSmallCapGainerEntity = super.findBy(primaryKey);
        if (null != bseSmallCapGainerEntity) {
            bseSmallCapGainerEntity.setNewEntity(false);
        }
        return bseSmallCapGainerEntity;
    }
}
